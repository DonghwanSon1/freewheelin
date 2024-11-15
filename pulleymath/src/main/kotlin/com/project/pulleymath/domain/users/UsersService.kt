package com.project.pulleymath.domain.users


import com.project.pulleymath.common.authority.TokenInfo
import com.project.pulleymath.common.authority.JwtTokenProvider
import com.project.pulleymath.common.exception.CommonException
import com.project.pulleymath.common.exception.CommonExceptionCode
import com.project.pulleymath.domain.userRole.UsersRoleService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.project.pulleymath.domain.userRole.enums.Role
import com.project.pulleymath.domain.users.rqrs.LoginRq
import com.project.pulleymath.domain.users.rqrs.UserRq
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.crypto.password.PasswordEncoder

@Service
@Transactional(readOnly = true)
class UsersService(
    private val usersRoleService: UsersRoleService,
    private val usersRepository: UsersRepository,
    private val authenticationManagerBuilder: AuthenticationManagerBuilder,
    private val jwtTokenProvider: JwtTokenProvider,
    private val passwordEncoder: PasswordEncoder
) {

  /**
   * 회원가입 (선생님, 학생)
   */
  @Transactional
  fun signUp(userRq: UserRq, role: Role): String {
    var user: Users? = usersRepository.findById(userRq.id!!)
    if (user != null) throw CommonException(CommonExceptionCode.DUPLICATE_ID)

    user = Users.createUser(userRq, passwordEncoder.encode(userRq.password))
    usersRepository.save(user)

    usersRoleService.signUpRole(user, role)

    return "회원가입이 완료되었습니다."
  }

  /**
   * 로그인 (토큰 발행)
   */
  fun login(loginRq: LoginRq): TokenInfo {
    val authenticationToken = UsernamePasswordAuthenticationToken(loginRq.id, loginRq.password)
    val authentication = authenticationManagerBuilder.`object`.authenticate(authenticationToken)

    return jwtTokenProvider.createToken(authentication)
  }

}