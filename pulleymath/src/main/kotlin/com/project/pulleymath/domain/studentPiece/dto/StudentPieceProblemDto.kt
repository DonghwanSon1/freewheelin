package com.project.pulleymath.domain.studentPiece.dto

import io.swagger.v3.oas.annotations.media.Schema

data class StudentPieceProblemDto(
    @Schema(description = "문제 유형코드")
    val unitCode: String? = null,

    @Schema(description = "문제 유형코드 이름")
    val unitCodeName: String? = null,

    @Schema(description = "문제 sn")
    val problemSn: Long? = null,

    @Schema(description = "문제 난이도")
    val level: Long? = null,

    @Schema(description = "문제 유형")
    val type: String? = null,

    @Schema(description = "학생 답안 sn")
    val studentAnswerSn: Long? = null,

    @Schema(description = "학생 답안")
    val studentAnswer: Long? = null,

    @Schema(description = "정답 여부")
    val grading: Boolean? = null,
)
