package com.project.pulleymath.domain.users


import com.example.demo.common.authority.TokenInfo
import com.project.pulleymath.common.authority.JwtTokenProvider
import com.project.pulleymath.common.exception.CommonException
import com.project.pulleymath.common.exception.CommonExceptionCode
import com.project.pulleymath.domain.userRole.UsersRoleService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.project.pulleymath.domain.userRole.enums.Role
import com.project.pulleymath.domain.users.rqrs.LoginRq
import com.project.pulleymath.domain.users.rqrs.UserRq
import com.project.pulleymath.domain.users.rqrs.UserRs
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder

@Service
@Transactional(readOnly = true)
class UsersService(
    private val usersRoleService: UsersRoleService,
    private val usersRepository: UsersRepository,
    private val authenticationManagerBuilder: AuthenticationManagerBuilder,
    private val jwtTokenProvider: JwtTokenProvider,
) {

  @Transactional
  fun signUp(userRq: UserRq, role: Role): String {
    // ID 중복 검사
    var user: Users? = usersRepository.findById(userRq.id!!)
    if (user != null) throw CommonException(CommonExceptionCode.DUPLICATE_ID)

    user = Users.createUser(userRq)
    usersRepository.save(user)


    usersRoleService.signUpRole(user, role)

    return "회원가입이 완료되었습니다."
  }

  /**
   * 로그인 -> 토큰 발행
   */
  fun login(loginRq: LoginRq): TokenInfo {
    val user: UserRs? = usersRepository.findUserWithRoles(loginRq.id!!)
    println(user)

    val authenticationToken = UsernamePasswordAuthenticationToken(loginRq.id, loginRq.password)
    val authentication = authenticationManagerBuilder.`object`.authenticate(authenticationToken)

    return jwtTokenProvider.createToken(authentication)
  }

//  /**
//   * 내 정보 조회
//   */
//  fun searchMyInfo(id: Long): MemberDtoResponse {
//    val member: Member = memberRepository.findByIdOrNull(id) ?: throw InvalidInputException("id", "회원번호(${id})가 존재하지 않는 유저입니다.")
//    return member.toDto()
//  }

}