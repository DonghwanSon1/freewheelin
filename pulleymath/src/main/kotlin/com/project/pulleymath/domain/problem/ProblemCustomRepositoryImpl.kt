package com.project.pulleymath.domain.problem

import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import com.project.pulleymath.domain.category.rqrs.CategoryRs
import com.project.pulleymath.domain.problem.rqrs.ProblemRs
import com.project.pulleymath.domain.unitCode.QUnitCode
import com.project.pulleymath.domain.unitCode.UnitCode
import com.querydsl.core.types.dsl.BooleanExpression

@Repository
class ProblemCustomRepositoryImpl(private val queryFactory: JPAQueryFactory) : ProblemCustomRepository {

    private val problem: QProblem = QProblem.problem
    private val unitCode: QUnitCode = QUnitCode.unitCode

    override fun findByUnitCode(unitCodeSnList: List<Long>, problemType: Type): MutableList<ProblemRs> {
        return queryFactory
            .select(
                Projections.fields(
                    ProblemRs::class.java,
                    problem.id,
                    problem.answer,
                    unitCode.code.`as`("unitCode"),
                    problem.level,
                    problem.type
                )
            )
            .from(problem)
            .join(problem.unitCode, unitCode)
            .where(
                problem.unitCode.sn.`in`(unitCodeSnList),
//                problem.level.`in`(level.levels),
                isEqualToProblemType(problemType)
            )
//            .limit(totalCount)
            .orderBy(
                problem.unitCode.sn.asc(),
                problem.type.asc(),
                problem.level.asc()
                )
            .fetch()
    }

    private fun isEqualToProblemType(problemType: Type): BooleanExpression? {
        return if (problemType != Type.ALL) {
            problem.type.eq(problemType.name)
        } else {
            null
        }
    }

//    override fun findAllCategory(): List<CategoryRs> {
//        return queryFactory
//            .select(
//                Projections.fields(
//                    CategoryRs::class.java,
//                    category.sn,
//                    category.name,
//                    category.createdAt,
//                    category.updatedAt
//                )
//            )
//            .from(category)
//            .orderBy(category.order.asc())
//            .fetch()
//    }
}