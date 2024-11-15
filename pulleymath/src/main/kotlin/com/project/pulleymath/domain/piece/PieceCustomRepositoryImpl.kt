package com.project.pulleymath.domain.piece

import com.project.pulleymath.domain.piece.dto.PieceAnalyzeDto
import com.project.pulleymath.domain.piece.rqrs.PieceRs
import com.project.pulleymath.domain.problem.QProblem
import com.project.pulleymath.domain.problem.enums.Type
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import com.project.pulleymath.domain.problem.rqrs.ProblemRs
import com.project.pulleymath.domain.studentPiece.QStudentPiece
import com.project.pulleymath.domain.unitCode.QUnitCode
import com.project.pulleymath.domain.users.QUsers
import com.project.pulleymath.domain.users.Users
import com.querydsl.core.types.dsl.BooleanExpression

@Repository
class PieceCustomRepositoryImpl(private val queryFactory: JPAQueryFactory) : PieceCustomRepository {

    private val piece: QPiece = QPiece.piece
    private val studentPiece: QStudentPiece = QStudentPiece.studentPiece
    private val user: QUsers = QUsers.users

    override fun findByCreatedBy(createdBy: Users): List<PieceRs>? {
        return queryFactory
            .select(
                Projections.fields(
                    PieceRs::class.java,
                    piece.sn.`as`("pieceSn"),
                    piece.name
                )
            )
            .from(piece)
            .where(piece.createdBy.eq(createdBy))
            .orderBy(piece.sn.desc())
            .fetch()
    }

    override fun searchPieceAnalyze(pieceSn: Long, createdBy: Users): List<PieceAnalyzeDto>? {
        return queryFactory
            .select(
                Projections.fields(
                    PieceAnalyzeDto::class.java,
                    piece.sn.`as`("pieceSn"),
                    piece.name.`as`("pieceName"),
                    studentPiece.sn.`as`("studentPieceSn"),
                    studentPiece.studentSn.sn.`as`("studentSn"),
                    user.name.`as`("studentName"),
                    studentPiece.correctRate.`as`("pieceCorrectRate")
                )
            )
            .from(piece)
            .leftJoin(studentPiece).on(studentPiece.piece.eq(piece))
            .leftJoin(user).on(user.eq(studentPiece.studentSn))
            .where(
                piece.sn.eq(pieceSn),
                piece.createdBy.eq(createdBy)
            )
            .orderBy(piece.sn.desc())
            .fetch()
    }

}