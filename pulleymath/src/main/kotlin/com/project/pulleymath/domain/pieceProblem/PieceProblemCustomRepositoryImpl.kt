package com.project.pulleymath.domain.pieceProblem

import com.project.pulleymath.domain.piece.Piece
import com.project.pulleymath.domain.pieceProblem.dto.PieceProblemSimpleDto
import com.project.pulleymath.domain.problem.QProblem
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import com.project.pulleymath.domain.unitCode.QUnitCode

@Repository
class PieceProblemCustomRepositoryImpl(private val queryFactory: JPAQueryFactory) : PieceProblemCustomRepository {

    private val problem: QProblem = QProblem.problem
    private val unitCode: QUnitCode = QUnitCode.unitCode
    private val pieceProblem: QPieceProblem = QPieceProblem.pieceProblem

    override fun searchSimplePieceProblem(piece: Piece): List<PieceProblemSimpleDto>? {
        return queryFactory
            .select(
                Projections.fields(
                    PieceProblemSimpleDto::class.java,
                    problem.sn.`as`("problemSn"),
                    problem.answer.`as`("problemAnswer")
                )
            )
            .from(pieceProblem)
            .join(pieceProblem.problem, problem)
            .where(pieceProblem.piece.eq(piece))
            .fetch()

    }
}