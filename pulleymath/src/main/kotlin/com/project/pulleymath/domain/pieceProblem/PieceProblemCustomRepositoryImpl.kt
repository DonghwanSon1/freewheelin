package com.project.pulleymath.domain.pieceProblem

import com.project.pulleymath.domain.piece.Piece
import com.project.pulleymath.domain.pieceProblem.dto.PieceProblemSimpleDto
import com.project.pulleymath.domain.pieceProblem.rqrs.PieceProblemAnalyzeRs
import com.project.pulleymath.domain.problem.QProblem
import com.project.pulleymath.domain.studentPiece.QStudentPiece
import com.project.pulleymath.domain.studentPieceAnswer.QStudentPieceAnswer
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class PieceProblemCustomRepositoryImpl(private val queryFactory: JPAQueryFactory) : PieceProblemCustomRepository {

    private val problem: QProblem = QProblem.problem
    private val pieceProblem: QPieceProblem = QPieceProblem.pieceProblem
    private val studentPiece: QStudentPiece = QStudentPiece.studentPiece
    private val studentPieceAnswer: QStudentPieceAnswer = QStudentPieceAnswer.studentPieceAnswer

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

    override fun searchPieceProblemAnalyze(pieceSn: Long): List<PieceProblemAnalyzeRs>? {
        return queryFactory
            .select(
                Projections.fields(
                    PieceProblemAnalyzeRs::class.java,
                    pieceProblem.problem.sn.`as`("problemSn"),
                    studentPieceAnswer.grading.`when`(true).then(1).otherwise(0).sum().`as`("problemCorrectCount")
                )
            )
            .from(pieceProblem)
            .leftJoin(studentPiece).on(studentPiece.piece.eq(pieceProblem.piece))
            .leftJoin(studentPieceAnswer).on(
                studentPieceAnswer.studentPiece.eq(studentPiece),
                studentPieceAnswer.problem.eq(pieceProblem.problem)
                )
            .where(pieceProblem.piece.sn.eq(pieceSn))
            .groupBy(pieceProblem.problem.sn)
            .fetch()
    }
}