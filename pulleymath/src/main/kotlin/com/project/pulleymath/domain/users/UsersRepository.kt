package com.project.pulleymath.domain.users

import com.project.pulleymath.domain.users.rqrs.UserRs
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UsersRepository: JpaRepository<Users, Long>, UsersCustomRepository {
  fun findById(id: String): Users?
}