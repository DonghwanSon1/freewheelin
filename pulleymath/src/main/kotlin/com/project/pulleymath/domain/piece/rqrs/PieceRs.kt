package com.project.pulleymath.domain.piece.rqrs

import io.swagger.v3.oas.annotations.media.Schema

data class PieceRs(
    @Schema(description = "학습지 sn")
    val pieceSn: Long? = null,

    @Schema(description = "학습지 이름")
    val name: String? = null,

)
