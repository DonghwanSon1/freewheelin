package com.project.pulleymath.domain.studentPiece


import com.project.pulleymath.common.exception.CommonException
import com.project.pulleymath.common.exception.CommonExceptionCode
import com.project.pulleymath.domain.piece.Piece
import com.project.pulleymath.domain.piece.PieceService
import com.project.pulleymath.domain.pieceProblem.PieceProblemService
import com.project.pulleymath.domain.pieceProblem.dto.PieceProblemDto
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
   *  - 학습지를 생성 시 문제를 1문제 이상은 저장해야 하기 때문에 학습지의 문제 조회 시 데이터가 없다면 데이터 손실로 인한 Exception
   *  - Rs 대로 응답값을 제공하기 위해 unitCode로 GroupBy 하고, 각각의 Rs 형식에 맞춰 응답값을 생성하여 응답한다.
   */
  fun searchStudentPieceProblem(studentPieceSn: Long, userSn: Long): List<StudentPieceProblemRs>? {
    // studentPiece check
    val studentPiece: StudentPiece = this.checkStudentPiece(studentPieceSn, Users.from(userSn))

    // 위에서 학생 학습지가 할당되었거나 존재한다면, 해당 학습지 안에는 무조건 문제가 있음. -> 따라서 데이터가 없다면, 데이터 손실로 인한 Exception 발생한다.
    val dto: List<PieceProblemDto> = pieceProblemService.searchPieceProblem(studentPiece.piece!!)
        ?: throw CommonException(CommonExceptionCode.DATA_LOSS)

    // 학습지에 속한 문제들을 가져온 DTO 를 통해 RS 대로 응답 해줄 수 있게 unitCode로 GroupBy 한 후 Rs 형식대로 만들어 Return 한다.
    val groupByUnitCode = dto.groupBy { it.unitCode }
        .map { (unitCode, problems) -> StudentPieceProblemRs.of(unitCode!!, problems.first().unitCodeName!!,
          problems.map { StudentPieceProblemDetailRs.of(it.problemSn!!, it.level!!, it.type!!) }
        ) }

    return groupByUnitCode
  }

  @Transactional
  fun saveStudentPieceProblemAnswer(studentPieceSn: Long,
                                    userSn: Long,
                                    studentPieceProblemAnswerRq: List<StudentPieceProblemAnswerRq>)
  : StudentPieceProblemAnswerRs {
    // studentPiece check
    val studentPiece: StudentPiece = this.checkStudentPiece(studentPieceSn, Users.from(userSn))

    val dto: List<PieceProblemSimpleDto> = pieceProblemService.searchSimplePieceProblem(studentPiece.piece!!)
        ?: throw CommonException(CommonExceptionCode.DATA_LOSS)

    val resultRs: StudentPieceProblemAnswerRs = studentPieceAnswerService.saveStudentPieceProblemAnswer(
        studentPieceSn, studentPieceProblemAnswerRq, dto)

    studentPieceRepository.save(studentPiece.updateCorrectRate(resultRs.correctRate))

    return resultRs
  }

  /**
   * 학생 학습지가 있는지, 할당받은 학습지인지 판별하는 private 함수
   * - studentPieceSn 없거나 로그인한 학생이 할당받지 않은 학습지라면 Exception 발생
   */
  private fun checkStudentPiece(studentPieceSn: Long, user:Users): StudentPiece {
    return studentPieceRepository.findBySnAndStudentSn(studentPieceSn, user)
        ?: throw CommonException(CommonExceptionCode.INVALID_STUDENT_PIECE)
  }

}