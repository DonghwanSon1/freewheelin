package com.project.pulleymath.domain.users.entity

import com.project.pulleymath.domain.unitCode.UnitCode
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "users")
data class Users(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sn")
    val sn: Long? = null,

    @Column(name = "id", unique = true, nullable = false)
    val id: String? = null,

    @Column(name = "password", nullable = false)
    val password: String? = null,

    @Column(name = "name", nullable = false)
    val name: String? = null,

) {
}