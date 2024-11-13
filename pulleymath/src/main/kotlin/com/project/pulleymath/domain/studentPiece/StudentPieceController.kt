package com.project.pulleymath.domain.studentPiece

import com.project.pulleymath.common.exception.CommonException
import com.project.pulleymath.common.exception.CommonExceptionCode
import com.project.pulleymath.common.response.BaseResponse
import com.project.pulleymath.common.response.CustomUser
import com.project.pulleymath.domain.problem.enums.Level
import com.project.pulleymath.domain.problem.enums.Type
import com.project.pulleymath.domain.problem.rqrs.ProblemListRs
import com.project.pulleymath.domain.studentPiece.rqrs.StudentPieceProblemRs
import com.project.pulleymath.domain.studentPiece.rqrs.StudentPieceRs
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/student-piece")
@Tag(name = "StudentPiece", description = "학생 학습지 관련 API")
class StudentPieceController(
    private val studentPieceService: StudentPieceService
) {

  /**
   * 학생 학습지 조회 API
   *
   * 참고
   *  - (4번 문제 전) 학습지의 문제 조회하기 전에 자신이 가지고 있는 학습지 리스트 조회 먼저 한다.
   *  - 로그인 후 토큰을 발급 받고 헤더값에 넣어야 호출 가능함!
   *  - 시큐리티를 통해 유저가 학생이 아니면 해당 API를 호출 할 수 없다.
   *  - 토큰을 통해 학생의 SN을 구하고 자신이 할당 받은 학습지를 조회한다.
   *
   */
  // TODO 추후 시간되면 페이징 넣기
  @GetMapping
  @Operation(summary = "학생 학습지 조회", description = "자신이 할당 받은 학습지를 조회합니다.")
  fun searchStudentPiece(): BaseResponse<List<StudentPieceRs>> {
    // 토큰을 통해 학생의 Sn을 추출한다.
    val userSn = (SecurityContextHolder.getContext().authentication.principal as CustomUser).sn
    return BaseResponse(data = studentPieceService.searchStudentPiece(userSn))
  }

  /**
   * 할당받은 학습지 문제 조회 API
   *
   * 참고
   *  - 로그인 후 토큰을 발급 받고 헤더값에 넣어야 호출 가능함!
   *  - 시큐리티를 통해 유저가 학생이 아니면 해당 API를 호출 할 수 없다.
   *  - 학생 학습지 조회 API를 통해 studentPieceSn를 사용한다.
   *
   */
  @GetMapping("/problem")
  @Operation(summary = "할당 받은 학습지 문제 조회", description = "자신이 할당 받은 학습지의 문제를 조회합니다.")
  fun searchStudentPieceProblem(@RequestParam studentPieceSn: Long): BaseResponse<List<StudentPieceProblemRs>> {
    // 토큰을 통해 학생의 Sn을 추출한다.
    val userSn = (SecurityContextHolder.getContext().authentication.principal as CustomUser).sn
    return BaseResponse(data = studentPieceService.searchStudentPieceProblem(studentPieceSn, userSn))
  }
}