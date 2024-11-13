package com.project.pulleymath.domain.studentPiece.rqrs

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

data class StudentPieceProblemDetailRs(
    @Schema(description = "문제 sn")
    val problemSn: Long? = null,

    @Schema(description = "문제 난이도")
    val level: Long? = null,

    @Schema(description = "문제 유형")
    val type: String? = null,

){
    companion object {
        fun of(problemSn: Long, level: Long, type: String): StudentPieceProblemDetailRs {
            return StudentPieceProblemDetailRs(
                problemSn = problemSn,
                level = level,
                type = type
            )
        }
    }
}
