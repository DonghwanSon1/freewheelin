package com.project.pulleymath.domain.problem

import com.project.pulleymath.common.exception.CommonException
import com.project.pulleymath.common.exception.CommonExceptionCode
import com.project.pulleymath.common.response.BaseResponse
import com.project.pulleymath.domain.category.rqrs.CategoryRq
import com.project.pulleymath.domain.category.rqrs.CategoryRs
import com.project.pulleymath.domain.problem.rqrs.ProblemListRs
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/problem")
@Tag(name = "Problem", description = "문제 관련 API")
class ProblemController(
    private val problemService: ProblemService
) {
    @GetMapping
    @Operation(summary = "문제 조회", description = "문제 중 파라미터별 조회합니다.")
    fun searchProblem(@RequestParam totalCount: Long,
                      @RequestParam unitCodeSnList: List<Long>,
                      @RequestParam level: Level,
                      @RequestParam problemType: Type): BaseResponse<ProblemListRs> {
        return BaseResponse(data = problemService.search(totalCount, unitCodeSnList, level, problemType))
    }
//
//    @PostMapping
//    @Operation(summary = "카테고리 다중 저장", description = "카테고리를 다중 저장합니다.")
//    fun saveCategory(@RequestBody categoryRqList: List<CategoryRq>) {
//        // 비워있거나 Null로 들어올 시 Exception 발생
//        if (categoryRqList.isNullOrEmpty()) throw CommonException(CommonExceptionCode.BAD_REQUEST)
//        categoryService.saveCategory(categoryRqList)
//    }
//
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