package com.project.pulleymath.domain.piece


import com.project.pulleymath.common.exception.CommonException
import com.project.pulleymath.common.exception.CommonExceptionCode
import com.project.pulleymath.domain.piece.dto.PieceAnalyzeDto
import com.project.pulleymath.domain.piece.rqrs.PieceAnalyzeRs
import com.project.pulleymath.domain.piece.rqrs.PieceRq
import com.project.pulleymath.domain.piece.rqrs.PieceRs
import com.project.pulleymath.domain.piece.rqrs.PieceStudentAnalyzeRs
import com.project.pulleymath.domain.pieceProblem.PieceProblemService
import com.project.pulleymath.domain.pieceProblem.rqrs.PieceProblemAnalyzeRs
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

  /**
   * 자신이 만든 학습지를 조회하는 함수
   *  - 토큰을 통해 userSn 을 이용한 조회
   */
  fun searchPiece(userSn: Long): List<PieceRs>? {
    return pieceRepository.findByCreatedBy(Users.from(userSn))
  }

  /**
   * 자신이 만든 학습지에 대해 통계를 조회하는 함수
   *  - 토큰의 UserSn으로 자신이 만든 학습지인지 판별 후 없는 학습지 또는 만든 학습지가 아니면 Exception
   *  - 출제한 학생이 있다면, 학생 정보를 가져오고 아니면 빈배열을 제공한다.
   *  - 정답률을 계산(학생들의 맞춘 개수 / 할당받은 학생 수) * 100 으로 정답률을 계산하여 제공한다. (Int)
   */
  fun searchPieceAnalyze(pieceSn: Long, userSn: Long): PieceAnalyzeRs {
    // pieceSn 이 없거나 자신이 만든 학습지가 아니면 Exception 발생한다.
    val dto: List<PieceAnalyzeDto> = pieceRepository.searchPieceAnalyze(pieceSn, Users.from(userSn))
        .takeIf { it!!.isNotEmpty() } ?: throw CommonException(CommonExceptionCode.NOT_EXIST_PIECE)

    // 출제한 학생들이 없다면 빈배열로 응답값을 주고 출제한 학생이 있다면, 학생 정보를 Rs 형식에 맞춘다.
    val pieceStudentAnalyzeRs: List<PieceStudentAnalyzeRs> = dto.filter { it.studentSn != null }
            .map { PieceStudentAnalyzeRs.of(it.studentSn, it.studentName, it.pieceCorrectRate) }

    // 학습지 문제 서비스에서 가져온 데이터를 가지고 문제별 정답률을 계산 후 Rs 형식에 맞춘다. - 학습지를 생성 시 문제는 필수로 주기 때문에 !! 한다.
    val pieceProblemAnalyzeList: List<PieceProblemAnalyzeRs> = pieceProblemService.searchPieceProblemAnalyze(pieceSn)!!
        .map { it.calculateCorrectRate(pieceStudentAnalyzeRs.size.toDouble())}

    // 통계 Rs 형식에 맞춰 응답값을 제공한다. - 학습지가 없거나, 할당받지 않았다면 Exception 처리를 했기 때문에 pieceSn, pieceName 도 !! 한다.
    return PieceAnalyzeRs.of(dto.first().pieceSn!!, dto.first().pieceName!!, pieceStudentAnalyzeRs, pieceProblemAnalyzeList)
  }
}