package com.project.pulleymath.domain.studentPieceAnswer

import com.project.pulleymath.domain.piece.QPiece
import com.project.pulleymath.domain.problem.QProblem
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class StudentPieceAnswerCustomRepositoryImpl(private val queryFactory: JPAQueryFactory) : StudentPieceAnswerCustomRepository {

    private val problem: QProblem = QProblem.problem
    private val piece: QPiece = QPiece.piece
    private val studentPiece: QStudentPieceAnswer = QStudentPieceAnswer.studentPieceAnswer
}