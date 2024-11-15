package com.project.pulleymath.common.authority

import com.project.pulleymath.common.response.CustomUser
import com.project.pulleymath.domain.users.UsersRepository
import com.project.pulleymath.domain.users.rqrs.UserRs
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val usersRepository: UsersRepository,
    private val passwordEncoder: PasswordEncoder,
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails =
        usersRepository.findUserWithRoles(username)
            ?.let { createUserDetails(it) } ?: throw UsernameNotFoundException("해당 유저는 없습니다.")

    private fun createUserDetails(user: UserRs): UserDetails =
        CustomUser(
            user.sn!!,
            user.id!!,
            user.password.toString(),
            listOf(SimpleGrantedAuthority(user.role))
        )
}