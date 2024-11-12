package com.project.pulleymath.domain.problem.rqrs

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

data class ProblemListRs(
    @Schema(description = "문제 리스트")
    val problemList: List<ProblemRs>? = null,
) {
    companion object {
        fun createProblemListRs(problemRs: List<ProblemRs>): ProblemListRs {
            return ProblemListRs(
                problemList = problemRs
            )
        }
    }
}
