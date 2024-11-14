package com.project.pulleymath.domain.studentPiece

import com.project.pulleymath.domain.piece.QPiece
import com.project.pulleymath.domain.pieceProblem.QPieceProblem
import com.project.pulleymath.domain.pieceProblem.dto.PieceProblemDto
import com.project.pulleymath.domain.problem.QProblem
import com.project.pulleymath.domain.problem.enums.Type
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import com.project.pulleymath.domain.problem.rqrs.ProblemRs
import com.project.pulleymath.domain.studentPiece.rqrs.StudentPieceRs
import com.project.pulleymath.domain.studentPieceAnswer.QStudentPieceAnswer
import com.project.pulleymath.domain.unitCode.QUnitCode
import com.project.pulleymath.domain.users.QUsers
import com.project.pulleymath.domain.users.Users
import com.querydsl.core.types.dsl.BooleanExpression

@Repository
class StudentPieceCustomRepositoryImpl(private val queryFactory: JPAQueryFactory) : StudentPieceCustomRepository {

    private val studentPiece: QStudentPiece = QStudentPiece.studentPiece
    private val piece: QPiece = QPiece.piece
    private val users: QUsers = QUsers.users
    private val problem: QProblem = QProblem.problem
    private val unitCode: QUnitCode = QUnitCode.unitCode
    private val pieceProblem: QPieceProblem = QPieceProblem.pieceProblem
    private val studentPieceAnswer: QStudentPieceAnswer = QStudentPieceAnswer.studentPieceAnswer

    override fun searchStudentPiece(student: Users): List<StudentPieceRs>? {
        return queryFactory
            .select(
                Projections.fields(
                    StudentPieceRs::class.java,
                    studentPiece.sn.`as`("studentPieceSn"),
                    piece.sn.`as`("pieceSn"),
                    piece.name.`as`("pieceName"),
                    users.name.`as`("teacherName"),
                    studentPiece.correctRate
                )
            )
            .from(studentPiece)
            .join(studentPiece.piece, piece)
            .join(piece.createdBy, users)
            .where(studentPiece.studentSn.eq(student))
            // 최신 할당받은 학습지 순
            .orderBy(studentPiece.sn.desc())
            .fetch()
    }

    override fun searchPieceProblem(studentPieceSn: Long, student: Users): List<PieceProblemDto>? {
        return queryFactory
            .select(
                Projections.fields(
                    PieceProblemDto::class.java,
                    unitCode.code.`as`("unitCode"),
                    unitCode.name.`as`("unitCodeName"),
                    problem.sn.`as`("problemSn"),
                    problem.level,
                    problem.type,
                    studentPieceAnswer.sn.`as`("studentAnswerSn"),
                    studentPieceAnswer.studentAnswer,
                    studentPieceAnswer.grading
                )
            )
            .from(studentPiece)
            .join(pieceProblem).on(pieceProblem.piece.eq(studentPiece.piece))
            .join(pieceProblem.problem, problem)
            .join(problem.unitCode, unitCode)
            .leftJoin(studentPieceAnswer).on(
                studentPieceAnswer.studentPiece.eq(studentPiece),
                studentPieceAnswer.problem.eq(problem))
            .where(studentPiece.sn.eq(studentPieceSn),
                studentPiece.studentSn.eq(student))
            .orderBy(problem.type.asc(), problem.level.asc())
            .fetch()

    }
}