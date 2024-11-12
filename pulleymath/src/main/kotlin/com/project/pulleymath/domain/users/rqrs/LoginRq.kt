package com.project.pulleymath.domain.users.rqrs

import io.swagger.v3.oas.annotations.media.Schema

data class LoginRq(

    @Schema(description = "유저 id")
    val id: String? = null,

    @Schema(description = "유저 PW")
    val password: String? = null
) {
}
