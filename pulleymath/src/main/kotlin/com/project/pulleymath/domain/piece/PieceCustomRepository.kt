package com.project.pulleymath.domain.piece

import com.project.pulleymath.domain.piece.dto.PieceAnalyzeDto
import com.project.pulleymath.domain.piece.rqrs.PieceRs
import com.project.pulleymath.domain.users.Users


interface PieceCustomRepository {

  fun findByCreatedBy(createdBy: Users): List<PieceRs>?
  fun searchPieceAnalyze(pieceSn: Long, createdBy: Users): List<PieceAnalyzeDto>?
}