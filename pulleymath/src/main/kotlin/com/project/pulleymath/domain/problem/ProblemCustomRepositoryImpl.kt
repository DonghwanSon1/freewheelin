package com.project.pulleymath.domain.problem

import com.project.pulleymath.domain.problem.enums.Type
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import com.project.pulleymath.domain.problem.rqrs.ProblemRs
import com.project.pulleymath.domain.unitCode.QUnitCode
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
                    problem.sn,
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
                isEqualToProblemType(problemType)
            )
            .orderBy(
                // 최신 데이터를 위해 유형코드는 DESC로 지정한다.
                problem.unitCode.sn.desc(),
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
}