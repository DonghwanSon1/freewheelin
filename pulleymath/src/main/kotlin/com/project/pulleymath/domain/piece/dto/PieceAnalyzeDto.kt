package com.project.pulleymath.domain.piece.dto

import io.swagger.v3.oas.annotations.media.Schema

data class PieceAnalyzeDto(

    @Schema(description = "학습지 sn")
    val pieceSn: Long? = null,

    @Schema(description = "학습지 이름")
    val pieceName: String? = null,

    @Schema(description = "학생 학습지 sn")
    val studentPieceSn: Long? = null,

    @Schema(description = "학생 sn")
    val studentSn: Long? = null,

    @Schema(description = "학생 이름")
    val studentName: String? = null,

    @Schema(description = "출제한 학생들의 학습지 정답률")
    val pieceCorrectRate: Int? = null,

)
