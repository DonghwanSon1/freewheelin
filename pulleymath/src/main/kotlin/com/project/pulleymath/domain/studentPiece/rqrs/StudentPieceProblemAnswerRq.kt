package com.project.pulleymath.domain.studentPiece.rqrs

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

data class StudentPieceProblemAnswerRq(
    @Schema(description = "문제 sn")
    val problemSn: Long? = null,

    @Schema(description = "제출한 답안")
    val studentAnswer: Long? = null,

){
}
