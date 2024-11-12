package com.project.pulleymath.domain.studentPiece

import com.project.pulleymath.common.response.BaseResponse
import com.project.pulleymath.domain.problem.enums.Level
import com.project.pulleymath.domain.problem.enums.Type
import com.project.pulleymath.domain.problem.rqrs.ProblemListRs
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/student-piece")
@Tag(name = "StudentPiece", description = "학생 학습지 관련 API")
class StudentPieceController(
    private val studentPieceService: StudentPieceService
) {

}