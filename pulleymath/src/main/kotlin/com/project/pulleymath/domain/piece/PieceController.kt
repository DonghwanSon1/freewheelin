package com.project.pulleymath.domain.piece

import com.project.pulleymath.common.response.BaseResponse
import com.project.pulleymath.domain.problem.enums.Level
import com.project.pulleymath.domain.problem.enums.Type
import com.project.pulleymath.domain.problem.rqrs.ProblemListRs
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/piece")
@Tag(name = "Piece", description = "학습지 관련 API")
class PieceController(
    private val pieceService: PieceService
) {
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