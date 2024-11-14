package com.project.pulleymath.domain.studentPiece.rqrs

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

data class StudentPieceProblemAnswerRq(
    // 재 제출시 필요한 sn값 (첫 제출이면 해당 sn 없이 요청 해야함)
    @Schema(description = "학생 답안 sn")
    val studentAnswerSn: Long? = null,

    @Schema(description = "문제 sn")
    val problemSn: Long? = null,

    @Schema(description = "제출한 답안")
    val studentAnswer: Long? = null,

){
}
