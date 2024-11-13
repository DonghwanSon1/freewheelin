package com.project.pulleymath.domain.pieceProblem

import com.project.pulleymath.domain.piece.Piece
import com.project.pulleymath.domain.pieceProblem.dto.PieceProblemDto
import com.project.pulleymath.domain.problem.enums.Type
import com.project.pulleymath.domain.problem.rqrs.ProblemRs


interface PieceProblemCustomRepository {
  fun searchPieceProblem(piece: Piece): List<PieceProblemDto>?
}