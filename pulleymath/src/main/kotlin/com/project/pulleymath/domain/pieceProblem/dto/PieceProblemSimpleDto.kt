package com.project.pulleymath.domain.pieceProblem.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

data class PieceProblemSimpleDto(

    @Schema(description = "문제 sn")
    val problemSn: Long? = null,

    @Schema(description = "문제 답")
    val problemAnswer: Long? = null,

)
