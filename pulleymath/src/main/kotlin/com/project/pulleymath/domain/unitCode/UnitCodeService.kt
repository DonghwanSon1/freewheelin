package com.project.pulleymath.domain.unitCode


import com.project.pulleymath.common.exception.CommonException
import com.project.pulleymath.common.exception.CommonExceptionCode
import com.project.pulleymath.domain.piece.dto.PieceAnalyzeDto
import com.project.pulleymath.domain.piece.rqrs.PieceAnalyzeRs
import com.project.pulleymath.domain.piece.rqrs.PieceRq
import com.project.pulleymath.domain.piece.rqrs.PieceRs
import com.project.pulleymath.domain.piece.rqrs.PieceStudentAnalyzeRs
import com.project.pulleymath.domain.pieceProblem.PieceProblemService
import com.project.pulleymath.domain.pieceProblem.rqrs.PieceProblemAnalyzeRs
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.project.pulleymath.domain.studentPiece.StudentPieceService
import com.project.pulleymath.domain.users.Users

@Service
@Transactional(readOnly = true)
class UnitCodeService(
    private val unitCodeRepository: UnitCodeRepository
) {

  /**
   * 유형 코드를 조회하는 함수
   */
  fun searchUnitCode(): List<UnitCode>? {
    return unitCodeRepository.findAll()
  }
}