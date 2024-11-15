package com.project.pulleymath.domain.studentPiece


import com.project.pulleymath.common.exception.CommonException
import com.project.pulleymath.common.exception.CommonExceptionCode
import com.project.pulleymath.domain.piece.Piece
import com.project.pulleymath.domain.pieceProblem.PieceProblemService
import com.project.pulleymath.domain.studentPiece.dto.StudentPieceProblemDto
import com.project.pulleymath.domain.pieceProblem.dto.PieceProblemSimpleDto
import com.project.pulleymath.domain.studentPiece.rqrs.*
import com.project.pulleymath.domain.studentPieceAnswer.StudentPieceAnswerService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.project.pulleymath.domain.users.Users

@Service
@Transactional(readOnly = true)
class StudentPieceService(
    private val pieceProblemService: PieceProblemService,
    private val studentPieceAnswerService: StudentPieceAnswerService,
    private val studentPieceRepository: StudentPieceRepository
) {

  /**
   * 학생 학습지 테이블에 저장 하는 함수
   *  - 이미 학습지를 가지고 있다면, 무시하고 없는 학생만 학습지 저장한다.
   */
  @Transactional
  fun saveStudentPiece(piece: Piece, studentSns: List<Long>) {

    // Piece를 가지고 가지고 있는 학생들을 추린 후 이미 가지고 있는 학생들을 필터 하기 위해 Map 으로 변경한다.
    val studentPieceMap: Map<Long, StudentPiece>? = studentPieceRepository.findByPiece(piece)?.associateBy { it.studentSn!!.sn ?: 0 }

    // 저장할 엔티티 리스트 변수를 선언한다.
    val studentPieceEntities = ArrayList<StudentPiece>()

    // 요청받은 학생Sn들을 for문 돌려 이미 저장되어 있는 학생들은 무시하고, 저장되지 않은 학생들은 엔티티 리스트 변수에 담고 저장한다.
    studentSns.forEach { studentSn ->
      if (!studentPieceMap!!.containsKey(studentSn)) {
        studentPieceEntities.add(StudentPiece.createStudentPiece(piece, Users.from(studentSn)))
      }
    }
    studentPieceRepository.saveAll(studentPieceEntities)
  }

  /**
   * 자기 자신이 할당 받은 학습지 조회 하는 함수
   */
  fun searchStudentPiece(userSn: Long): List<StudentPieceRs>? {
    // 자기가 속한 학습지 조회하여 Rs로 Return 한다.
    return studentPieceRepository.searchStudentPiece(Users.from(userSn))
  }

  /**
   * 할당 받은 학습지의 문제들을 조회 하는 함수
   *  - studentPieceSn 이 없거나 할당받지 않은 학습지라면 Exception
   *  - 이미 제출한 문제도 재 제출 할 수 있도록 조회 시 제출했던 문제들(studentAnswerSn, studentAnswer, grading)도 제공한다.
   *  - Rs 대로 응답값을 제공하기 위해 unitCode로 GroupBy 하고, 각각의 Rs 형식에 맞춰 응답값을 생성하여 응답한다.
   */
  fun searchStudentPieceProblem(studentPieceSn: Long, userSn: Long): List<StudentPieceProblemRs>? {
    // studentPieceSn 이 없거나 할당받지 않은 학습지라면 Exception
    val dto: List<StudentPieceProblemDto> = studentPieceRepository.searchStudentPieceProblem(studentPieceSn, Users.from(userSn))
        .takeIf { it!!.isNotEmpty() } ?: throw CommonException(CommonExceptionCode.INVALID_STUDENT_PIECE)

    // 가져온 DTO 를 통해 RS 대로 응답 해줄 수 있게 unitCode로 GroupBy 한 후 Rs 형식대로 만들어 Return 한다.
    val groupByUnitCode = dto.groupBy { it.unitCode }
        .map { (unitCode, problems) -> StudentPieceProblemRs.of(
            unitCode!!,
            problems.first().unitCodeName!!,
            problems.map { StudentPieceProblemDetailRs.of(
                it.problemSn!!, it.level!!, it.type!!, it.studentAnswerSn, it.studentAnswer, it.grading)
            }) }

    return groupByUnitCode
  }

  /**
   * 할당 받은 학습지를 채점 후 저장하는 함수
   *  - studentPieceSn 없거나 로그인한 학생이 할당받지 않은 학습지라면 Exception 발생
   *  - 학생 학습지가 할당되었거나 존재한다면, 해당 학습지 안에는 무조건 문제가 있음. -> 따라서 데이터가 없다면, 데이터 손실로 인한 Exception 발생한다.
   *  - 응답은 (학습지에 할당된 총 문제수, 채점 완료한 개수, 맞은 개수, 정답률) 이렇게 응답값을 제공한다.
   */
  @Transactional
  fun saveStudentPieceProblemAnswer(studentPieceSn: Long,
                                    userSn: Long,
                                    rq: List<StudentPieceProblemAnswerRq>)
  : StudentPieceProblemAnswerRs {
    // studentPieceSn 없거나 로그인한 학생이 할당받지 않은 학습지라면 Exception 발생
    val studentPiece: StudentPiece = studentPieceRepository.findBySnAndStudentSn(studentPieceSn, Users.from(userSn))
        ?: throw CommonException(CommonExceptionCode.INVALID_STUDENT_PIECE)

    // 위에서 학생 학습지가 할당되었거나 존재한다면, 해당 학습지 안에는 무조건 문제가 있음. -> 따라서 데이터가 없다면, 데이터 손실로 인한 Exception 발생한다.
    val dto: List<PieceProblemSimpleDto> = pieceProblemService.searchSimplePieceProblem(studentPiece.piece!!)
        ?: throw CommonException(CommonExceptionCode.DATA_LOSS)

    // 위에서 가져온 학습지의 문제 번호 및 답안을 Answer 서비스에 보내 채점 후 저장 하고, Rs값을 가져온다.
    val resultRs: StudentPieceProblemAnswerRs = studentPieceAnswerService.saveStudentPieceProblemAnswer(
        studentPieceSn, rq, dto)

    // Rs에서 학생의 학습지 정답률을 저장하기 위해 update 한 후 Rs를 return 한다.
    studentPieceRepository.save(studentPiece.updateCorrectRate(resultRs.correctRate))

    return resultRs
  }
}