package com.project.pulleymath.domain.studentPieceAnswer


import com.project.pulleymath.domain.pieceProblem.dto.PieceProblemDto
import com.project.pulleymath.domain.pieceProblem.dto.PieceProblemSimpleDto
import com.project.pulleymath.domain.studentPiece.StudentPieceRepository
import com.project.pulleymath.domain.studentPiece.rqrs.StudentPieceProblemAnswerRq
import com.project.pulleymath.domain.studentPiece.rqrs.StudentPieceProblemAnswerRs
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class StudentPieceAnswerService(
    private val studentPieceAnswerRepository: StudentPieceAnswerRepository
) {

  @Transactional
  fun saveStudentPieceProblemAnswer(studentPieceSn: Long,
                                    studentPieceProblemAnswerRq: List<StudentPieceProblemAnswerRq>,
                                    dto: List<PieceProblemSimpleDto>)
  : StudentPieceProblemAnswerRs {

    val studentPieceAnswerEntities = ArrayList<StudentPieceAnswer>()
    val dtoMap: Map<Long, PieceProblemSimpleDto> = dto.associateBy { it.problemSn ?: 0 }
    var correctCount = 0

    // TODO FE에서 중복된 ProblemSn을 주면 안된다. -> 노션에 적을 내용
    studentPieceProblemAnswerRq.forEach { it ->
      if (dtoMap.containsKey(it.problemSn)) {
        if (it.studentAnswer == dtoMap[it.problemSn]!!.problemAnswer) {
          studentPieceAnswerEntities.add(StudentPieceAnswer.createStudentPieceAnswer(studentPieceSn, it.problemSn!!, it.studentAnswer!!, true))
          correctCount++
        } else {
          studentPieceAnswerEntities.add(StudentPieceAnswer.createStudentPieceAnswer(studentPieceSn, it.problemSn!!, it.studentAnswer!!, false))
        }
      }
    }

    studentPieceAnswerRepository.saveAll(studentPieceAnswerEntities)

    val result: StudentPieceProblemAnswerRs = StudentPieceProblemAnswerRs.of(
        dto.size, studentPieceProblemAnswerRq.size, correctCount)

    return result
  }
}