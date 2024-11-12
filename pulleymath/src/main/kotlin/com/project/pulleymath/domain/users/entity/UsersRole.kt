package com.project.pulleymath.domain.users.entity

import com.project.pulleymath.domain.users.enums.Role
import javax.persistence.*

@Entity
@Table(name = "users_role")
data class UsersRole(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sn")
    val sn: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_sn", referencedColumnName = "sn", nullable = false)
    val user: Users? = null,

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    val role: Role? = null,

    ) {
}