package com.project.pulleymath.domain.pieceProblem

import com.project.pulleymath.common.response.BaseResponse
import com.project.pulleymath.domain.problem.enums.Level
import com.project.pulleymath.domain.problem.enums.Type
import com.project.pulleymath.domain.problem.rqrs.ProblemListRs
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/piece-problem")
@Tag(name = "PieceProblem", description = "학습지 문제 관련 API")
class PieceProblemController(
    private val pieceProblemService: PieceProblemService
) {

}