package com.project.pulleymath.domain.users

import com.project.pulleymath.domain.users.entity.Users
import org.springframework.data.jpa.repository.JpaRepository

interface UsersRepository: JpaRepository<Users, String> {


}