package com.project.pulleymath.domain.piece.rqrs

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

data class PieceRs(
    @Schema(description = "학습지 sn")
    val pieceSn: Long? = null,

    @Schema(description = "학습지 이름")
    val name: String? = null,

)
