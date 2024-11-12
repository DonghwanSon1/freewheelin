package com.project.pulleymath.common.response

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User

class CustomUser(
    val sn: Long,
    id: String,
    password: String,
    authorities: Collection<GrantedAuthority>
) : User(id, password, authorities)