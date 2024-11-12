package com.project.pulleymath.domain.users

import com.example.demo.common.authority.TokenInfo
import com.project.pulleymath.common.response.BaseResponse
import com.project.pulleymath.common.response.CustomUser
import com.project.pulleymath.domain.userRole.enums.Role
import com.project.pulleymath.domain.users.rqrs.LoginRq
import com.project.pulleymath.domain.users.rqrs.UserRq
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "유저 관련 API")
class UsersController(
    private val usersService: UsersService
) {

  /**
   * 회원가입
   */
  @PostMapping("/teacher/signup")
  fun teacherSignUp(@RequestBody userRq: UserRq): BaseResponse<Unit> {
    val resultMsg: String = usersService.signUp(userRq, Role.TEACHER)
    return BaseResponse(message = resultMsg)
  }

  @PostMapping("/student/signup")
  fun studentSignUp(@RequestBody userRq: UserRq): BaseResponse<Unit> {
    val resultMsg: String = usersService.signUp(userRq, Role.STUDENT)
    return BaseResponse(message = resultMsg)
  }

  /**
   * 로그인
   */
  @PostMapping("/login")
  fun login(@RequestBody loginRq: LoginRq): BaseResponse<TokenInfo> {
    val tokenInfo = usersService.login(loginRq)
    return BaseResponse(data = tokenInfo)
  }

  /**
   * 내 정보 보기
   */
//  @GetMapping("/info")
//  fun searchMyInfo(): BaseResponse<Unit> {
//    val userId = (SecurityContextHolder.getContext().authentication.principal as CustomUser).sn
//    val response = usersService.searchMyInfo(userId)
//    return BaseResponse(data = response)
//  }

}