package com.project.pulleymath.domain.problem.rqrs

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

data class ProblemRs(
    @Schema(description = "문제 sn")
    val sn: Long? = null,

    @Schema(description = "정답")
    val answer: Long? = null,

    @Schema(description = "유형 코드")
    val unitCode: String? = null,

    @Schema(description = "레벨")
    val level: Long? = null,

    @Schema(description = "문제 형식")
    val type: String? = null,
)
