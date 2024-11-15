package com.project.pulleymath.domain.users

import com.project.pulleymath.domain.users.rqrs.UserRs

interface UsersCustomRepository {
  fun findUserWithRoles(id: String): UserRs?
}