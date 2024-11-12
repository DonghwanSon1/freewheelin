package com.project.pulleymath.domain.users.rqrs

import io.swagger.v3.oas.annotations.media.Schema

data class UserRs(

    @Schema(description = "유저 SN")
    val sn: Long? = null,

    @Schema(description = "유저 ID")
    val id: String? = null,

    @Schema(description = "유저 PW")
    val password: String? = null,

    @Schema(description = "유저 이름")
    val name: String? = null,

    @Schema(description = "유저 역할")
    val role: String? = null
)
