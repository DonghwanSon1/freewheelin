package com.project.pulleymath.domain.users.rqrs

import io.swagger.v3.oas.annotations.media.Schema

data class UserRq(

    @Schema(description = "유저 ID")
    val id: String?,

    @Schema(description = "유저 PW")
    val password: String,

    @Schema(description = "유저 이름")
    val name: String
)
