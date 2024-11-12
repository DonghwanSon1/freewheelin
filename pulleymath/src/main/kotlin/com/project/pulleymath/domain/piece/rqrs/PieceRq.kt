package com.project.pulleymath.domain.piece.rqrs

import io.swagger.v3.oas.annotations.media.Schema

data class PieceRq(

    @Schema(description = "학습지 이름")
    val name: String,

    @Schema(description = "문제 SN List")
    val problemSnList: List<Long>,

)
