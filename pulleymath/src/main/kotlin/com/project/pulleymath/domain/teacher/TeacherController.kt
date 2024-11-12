package com.project.pulleymath.domain.teacher

import com.project.pulleymath.common.exception.CommonException
import com.project.pulleymath.common.exception.CommonExceptionCode
import com.project.pulleymath.common.response.BaseResponse
import com.project.pulleymath.common.response.CustomUser
import com.project.pulleymath.domain.piece.PieceService
import com.project.pulleymath.domain.piece.rqrs.PieceRq
import com.project.pulleymath.domain.pieceProblem.PieceProblemService
import com.project.pulleymath.domain.problem.ProblemService
import com.project.pulleymath.domain.problem.enums.Level
import com.project.pulleymath.domain.problem.enums.Type
import com.project.pulleymath.domain.problem.rqrs.ProblemListRs
import com.project.pulleymath.domain.userRole.enums.Role
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/teacher")
@Tag(name = "Teacher", description = "선생님 전용 API")
class TeacherController(
    private val problemService: ProblemService,
    private val pieceService: PieceService
) {

    /**
     * 문제 조회 API
     *
     * 참고
     *  - 로그인 후 토큰을 발급 받고 헤더값에 넣어야 호출 가능함!
     *  - 시큐리티를 통해 유저가 선생님이 아니면 해당 API를 호출 할 수 없다.
     *  - 파라미터 별 문제들을 조회한다.
     */
    @GetMapping("/problem")
    @Operation(summary = "문제 조회", description = "문제 중 파라미터별 조회합니다.")
    fun searchProblem(@RequestParam totalCount: Long,
                      @RequestParam unitCodeSnList: List<Long>,
                      @RequestParam level: Level,
                      @RequestParam problemType: Type): BaseResponse<ProblemListRs> {
        return BaseResponse(data = problemService.searchProblem(totalCount, unitCodeSnList, level, problemType))
    }


    /**
     * 학습지 생성 API
     *
     * 참고
     *  - 로그인 후 토큰을 발급 받고 헤더값에 넣어야 호출 가능함!
     *  - 시큐리티를 통해 유저가 선생님이 아니면 해당 API를 호출 할 수 없다.
     *  - 학습지 이름이 없거나, 문제가 1개 이상 50개 까지 등록 가능하다.
     */
    @PostMapping("/piece")
    @Operation(summary = "학습지 생성", description = "선생님이 학습지를 생성합니다.")
    fun savePiece(@RequestBody pieceRq: PieceRq): BaseResponse<Unit> {

        // 학습지 이름이 비워있거나 Null로 들어올 시 Exception 발생
        if (pieceRq.name.isNullOrEmpty()) throw CommonException(CommonExceptionCode.EMPTY_PIECE_NAME)
        // 문제 리스트가 비워있거나 Null로 들어올 시 Exception 발생
        if (pieceRq.problemSnList.isNullOrEmpty() || pieceRq.problemSnList.size > 50)
            throw CommonException(CommonExceptionCode.EMPTY_OR_OVER_PROBLEM)

        // 토큰을 통해 UserSn을 가져온다.
        val userSn = (SecurityContextHolder.getContext().authentication.principal as CustomUser).sn
        val resultMsg: String = pieceService.savePiece(pieceRq, userSn)
        return BaseResponse(message = resultMsg)
    }

//    @PatchMapping
//    @Operation(summary = "카테고리 다중 수정", description = "카테고리를 다중 수정합니다.")
//    fun updateCategory(@RequestBody categoryRqList: List<CategoryRq>) {
//        // 비워있거나 Null로 들어올 시 Exception 발생
//        if (categoryRqList.isNullOrEmpty()) throw CommonException(CommonExceptionCode.BAD_REQUEST)
//        categoryService.saveCategory(categoryRqList)
//    }
//
//    @PostMapping("/delete")
//    @Operation(summary = "카테고리 다중 삭제", description = "다중 카테고리를 완전 삭제합니다.")
//    fun deleteCategory(@RequestBody snList: List<Long>) {
//        categoryService.deleteCategory(snList)
//    }

}