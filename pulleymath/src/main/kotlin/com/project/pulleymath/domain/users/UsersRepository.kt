package com.project.pulleymath.domain.users

import org.springframework.data.jpa.repository.JpaRepository

interface UsersRepository: JpaRepository<Users, Long>, UsersCustomRepository {
  fun findById(id: String): Users?
}