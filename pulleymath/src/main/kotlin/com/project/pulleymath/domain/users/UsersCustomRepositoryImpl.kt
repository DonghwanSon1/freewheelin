package com.project.pulleymath.domain.users

import com.project.pulleymath.domain.problem.enums.Type
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import com.project.pulleymath.domain.problem.rqrs.ProblemRs
import com.project.pulleymath.domain.unitCode.QUnitCode
import com.project.pulleymath.domain.userRole.QUsersRole
import com.project.pulleymath.domain.users.rqrs.UserRs
import com.querydsl.core.types.dsl.BooleanExpression

@Repository
class UsersCustomRepositoryImpl(private val queryFactory: JPAQueryFactory) : UsersCustomRepository {

    private val users: QUsers = QUsers.users
    private val userRole: QUsersRole = QUsersRole.usersRole

    override fun findUserWithRoles(id: String): UserRs? {
        return queryFactory
            .select(
                Projections.fields(
                    UserRs::class.java,
                    users.sn,
                    users.id,
                    users.password,
                    users.name,
                    userRole.role
                )
            )
            .from(users)
            .join(userRole).on(userRole.user.sn.eq(users.sn))
            .where(users.id.eq(id))
            .fetchOne()
    }
}