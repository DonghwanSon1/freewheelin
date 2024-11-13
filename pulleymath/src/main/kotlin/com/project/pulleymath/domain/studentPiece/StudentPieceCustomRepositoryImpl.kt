package com.project.pulleymath.domain.studentPiece

import com.project.pulleymath.domain.piece.QPiece
import com.project.pulleymath.domain.problem.QProblem
import com.project.pulleymath.domain.problem.enums.Type
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import com.project.pulleymath.domain.problem.rqrs.ProblemRs
import com.project.pulleymath.domain.studentPiece.rqrs.StudentPieceRs
import com.project.pulleymath.domain.unitCode.QUnitCode
import com.project.pulleymath.domain.users.QUsers
import com.project.pulleymath.domain.users.Users
import com.querydsl.core.types.dsl.BooleanExpression

@Repository
class StudentPieceCustomRepositoryImpl(private val queryFactory: JPAQueryFactory) : StudentPieceCustomRepository {

    private val studentPiece: QStudentPiece = QStudentPiece.studentPiece
    private val piece: QPiece = QPiece.piece
    private val user: QUsers = QUsers.users

    override fun searchStudentPiece(users: Users): List<StudentPieceRs>? {
        return queryFactory
            .select(
                Projections.fields(
                    StudentPieceRs::class.java,
                    studentPiece.sn.`as`("studentPieceSn"),
                    piece.sn.`as`("pieceSn"),
                    piece.name.`as`("pieceName"),
                    user.name.`as`("teacherName"),
                    studentPiece.correctRate
                )
            )
            .from(studentPiece)
            .join(studentPiece.piece, piece)
            .join(piece.createdBy, user)
            .where(studentPiece.studentSn.eq(users))
            // 최신 할당받은 학습지 순
            .orderBy(studentPiece.sn.desc())
            .fetch()
    }
}