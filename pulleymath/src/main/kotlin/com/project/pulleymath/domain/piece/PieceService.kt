package com.project.pulleymath.domain.piece


import com.project.pulleymath.common.exception.CommonException
import com.project.pulleymath.common.exception.CommonExceptionCode
import com.project.pulleymath.domain.piece.rqrs.PieceRq
import com.project.pulleymath.domain.pieceProblem.PieceProblemService
import com.project.pulleymath.domain.problem.enums.Level
import com.project.pulleymath.domain.problem.enums.Type
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.project.pulleymath.domain.problem.rqrs.ProblemListRs
import com.project.pulleymath.domain.problem.rqrs.ProblemRs
import com.project.pulleymath.domain.studentPiece.StudentPieceService
import com.project.pulleymath.domain.users.Users
import com.project.pulleymath.domain.users.UsersService

@Service
@Transactional(readOnly = true)
class PieceService(
    private val pieceRepository: PieceRepository,
    private val pieceProblemService: PieceProblemService,
    private val studentPieceService: StudentPieceService
) {

  /**
   * 학습지 테이블 및 학습지 문제 테이블에 저장하는 함수
   */
  @Transactional
  fun savePiece(pieceRq: PieceRq, userSn: Long): String {

    // Rq를 통해 학습지 이름과, 유저정보를 가지고 학습지 엔티티를 생성한 후 저장한다.
    val piece: Piece = Piece.createPiece(pieceRq.name, Users.from(userSn))
    pieceRepository.save(piece)

    // 저장한 학습지와 문제리스트들을 보내 학습지 문제 테이블에 저장할 수 있도록 한다.
    pieceProblemService.savePieceProblem(piece, pieceRq.problemSnList)

    return "학습지 생성이 완료되었습니다."
  }

  /**
   * 자신이 만든 학습지를 학생에게 출제하는 함수
   *  - 학생 학습지 테이블에 저장을 전달
   */
  @Transactional
  fun examPiece(pieceSn: Long, studentSns: List<Long>, userSn: Long): String {

    // 학습지가 없다면, Exception 발생
    val piece: Piece = pieceRepository.findBySn(pieceSn) ?: throw CommonException(CommonExceptionCode.NOT_EXIST_PIECE)
    // 학습지가 출제하려는 선생님이 만든게 아니라면 Exception 발생
    if (piece.createdBy!!.sn != userSn) throw CommonException(CommonExceptionCode.INVALID_PIECE)

    studentPieceService.saveStudentPiece(piece, studentSns)

    return "학습지 출제가 완료되었습니다."
  }
}