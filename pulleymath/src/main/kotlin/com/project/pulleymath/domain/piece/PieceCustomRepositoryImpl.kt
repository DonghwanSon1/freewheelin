package com.project.pulleymath.domain.piece

import com.project.pulleymath.domain.problem.QProblem
import com.project.pulleymath.domain.problem.enums.Type
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import com.project.pulleymath.domain.problem.rqrs.ProblemRs
import com.project.pulleymath.domain.unitCode.QUnitCode
import com.querydsl.core.types.dsl.BooleanExpression

@Repository
class PieceCustomRepositoryImpl(private val queryFactory: JPAQueryFactory) : PieceCustomRepository {

    private val problem: QProblem = QProblem.problem
    private val piece: QPiece = QPiece.piece


}