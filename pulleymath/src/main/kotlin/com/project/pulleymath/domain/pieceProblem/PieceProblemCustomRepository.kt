package com.project.pulleymath.domain.pieceProblem

import com.project.pulleymath.domain.piece.Piece
import com.project.pulleymath.domain.pieceProblem.dto.PieceProblemSimpleDto
import com.project.pulleymath.domain.pieceProblem.rqrs.PieceProblemAnalyzeRs


interface PieceProblemCustomRepository {
  fun searchSimplePieceProblem(piece: Piece): List<PieceProblemSimpleDto>?
  fun searchPieceProblemAnalyze(pieceSn: Long): List<PieceProblemAnalyzeRs>?
}