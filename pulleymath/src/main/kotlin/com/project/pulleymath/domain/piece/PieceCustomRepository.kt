package com.project.pulleymath.domain.piece

import com.project.pulleymath.domain.piece.rqrs.PieceRs
import com.project.pulleymath.domain.problem.enums.Type
import com.project.pulleymath.domain.problem.rqrs.ProblemRs
import com.project.pulleymath.domain.users.Users


interface PieceCustomRepository {

  fun findByCreatedBy(createdBy: Users): List<PieceRs>?
}