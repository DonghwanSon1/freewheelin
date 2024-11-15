package com.project.pulleymath.domain.studentPieceAnswer


import com.project.pulleymath.domain.pieceProblem.dto.PieceProblemSimpleDto
import com.project.pulleymath.domain.studentPiece.StudentPiece
import com.project.pulleymath.domain.studentPiece.rqrs.StudentPieceProblemAnswerRq
import com.project.pulleymath.domain.studentPiece.rqrs.StudentPieceProblemAnswerRs
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class StudentPieceAnswerService(
    private val studentPieceAnswerRepository: StudentPieceAnswerRepository
) {

  /**
   * 채점 후 저장하는 함수
   * - studentPieceSn 없거나 로그인한 학생이 할당받지 않은 학습지라면 Exception 발생
   * - studentAnswerSn 이 있다면 수정할 Rq 이므로 재채점은 한다.
   */
  @Transactional
  fun saveStudentPieceProblemAnswer(studentPieceSn: Long,
                                    rq: List<StudentPieceProblemAnswerRq>,
                                    dto: List<PieceProblemSimpleDto>)
  : StudentPieceProblemAnswerRs {

    // param 으로 받은 문제들의 sn 과 답을 비교하기 쉽게 Map 형식으로 변환 시킨다.
    val dtoMap: Map<Long, PieceProblemSimpleDto> = dto.associateBy { it.problemSn ?: 0 }

    // update 할 Rq를 Filter 를 통해 가져온 후 꺼내기 쉽게 Map 형식으로 변환 시킨다.
    val updateRq: Map<Long, StudentPieceProblemAnswerRq> = rq
        .filter { it.studentAnswerSn != null }
        .associateBy { it.studentAnswerSn!! }

    // 엔티티 리스트에 수정/생성 엔티티들을 담는다.
    val studentPieceAnswerEntities = ArrayList<StudentPieceAnswer>().apply {

      // 생성 엔티티는 filter 를 통해 create 할 Rq만 꺼내 채점 후 엔티티를 생성한다.
      addAll(rq.filter { it.studentAnswerSn == null }.map { rq ->
        val isCorrect = rq.studentAnswer == dtoMap[rq.problemSn]?.problemAnswer
        StudentPieceAnswer.createStudentPieceAnswer(studentPieceSn, rq.problemSn!!, rq.studentAnswer!!, isCorrect)
      })

      // UpdateForRq 가 비워있으면 업데이트 할 엔티티가 없는것이고, 있다면 업데이트 할 엔티티 가져온 후 재 채점 한 후 엔티티를 업데이트한다.
      if (updateRq.isNotEmpty()) {
        val updateEntities = studentPieceAnswerRepository.findBySnIn(updateRq.keys.toList())
        addAll(updateEntities.map { entity ->
          val isCorrect = updateRq[entity.sn]!!.studentAnswer == dtoMap[entity.problem!!.sn]?.problemAnswer
          entity.update(entity.studentAnswer!!, isCorrect)
        })
      }
    }

    // 담은 엔티티들을 저장한다.
    studentPieceAnswerRepository.saveAll(studentPieceAnswerEntities)

    // 최종 채점 결과를 가져오기 위해 지금까지 학생이 제출한 답안들을 가져온다.
    val gradingResult: List<StudentPieceAnswer>? = studentPieceAnswerRepository.findByStudentPiece(StudentPiece.from(studentPieceSn))
    // 가져온 결과지에서 채점된 개수를 가져온다.
    val correctCount: Int = gradingResult!!.count { it.grading == true }

    // 최종 채점 결과를 조회한걸로 Rs 형식에 맞춰 필요한 값을 넣어 생성 후 Return 한다.
    return StudentPieceProblemAnswerRs.of(dto.size, gradingResult.size, correctCount)
  }
}