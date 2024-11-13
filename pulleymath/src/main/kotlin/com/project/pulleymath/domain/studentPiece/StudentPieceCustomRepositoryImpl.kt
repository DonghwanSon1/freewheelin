package com.project.pulleymath.domain.studentPiece

import com.project.pulleymath.domain.piece.QPiece
import com.project.pulleymath.domain.problem.QProblem
import com.project.pulleymath.domain.problem.enums.Type
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import com.project.pulleymath.domain.problem.rqrs.ProblemRs
import com.project.pulleymath.domain.unitCode.QUnitCode
import com.project.pulleymath.domain.users.QUsers
import com.querydsl.core.types.dsl.BooleanExpression

@Repository
class StudentPieceCustomRepositoryImpl(private val queryFactory: JPAQueryFactory) : StudentPieceCustomRepository {

    private val studentPiece: QStudentPiece = QStudentPiece.studentPiece

}