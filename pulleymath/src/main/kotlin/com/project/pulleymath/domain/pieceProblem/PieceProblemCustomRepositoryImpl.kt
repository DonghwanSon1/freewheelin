package com.project.pulleymath.domain.pieceProblem

import com.project.pulleymath.domain.piece.Piece
import com.project.pulleymath.domain.piece.QPiece
import com.project.pulleymath.domain.pieceProblem.dto.PieceProblemDto
import com.project.pulleymath.domain.problem.QProblem
import com.project.pulleymath.domain.problem.enums.Type
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import com.project.pulleymath.domain.problem.rqrs.ProblemRs
import com.project.pulleymath.domain.studentPiece.rqrs.StudentPieceRs
import com.project.pulleymath.domain.unitCode.QUnitCode
import com.querydsl.core.types.dsl.BooleanExpression

@Repository
class PieceProblemCustomRepositoryImpl(private val queryFactory: JPAQueryFactory) : PieceProblemCustomRepository {

    private val problem: QProblem = QProblem.problem
    private val unitCode: QUnitCode = QUnitCode.unitCode
    private val pieceProblem: QPieceProblem = QPieceProblem.pieceProblem

    override fun searchPieceProblem(piece: Piece): List<PieceProblemDto>? {
        return queryFactory
            .select(
                Projections.fields(
                    PieceProblemDto::class.java,
                    unitCode.code.`as`("unitCode"),
                    unitCode.name.`as`("unitCodeName"),
                    problem.sn.`as`("problemSn"),
                    problem.level,
                    problem.type,
                )
            )
            .from(pieceProblem)
            .join(pieceProblem.problem, problem)
            .join(problem.unitCode, unitCode)
            .where(pieceProblem.piece.eq(piece))
            .orderBy(problem.type.asc(), problem.level.asc())
            .fetch()
    }
}