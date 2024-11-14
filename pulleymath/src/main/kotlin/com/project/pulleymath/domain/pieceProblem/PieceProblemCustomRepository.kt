package com.project.pulleymath.domain.pieceProblem

import com.project.pulleymath.domain.piece.Piece
import com.project.pulleymath.domain.pieceProblem.dto.PieceProblemSimpleDto


interface PieceProblemCustomRepository {
  fun searchSimplePieceProblem(piece: Piece): List<PieceProblemSimpleDto>?
}