package com.project.pulleymath.domain.userRole

import com.project.pulleymath.domain.users.Users
import com.project.pulleymath.domain.userRole.enums.Role
import javax.persistence.*

@Entity
@Table(name = "users_role")
class UsersRole(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sn")
    val sn: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = ForeignKey(name = "FK_USERS_ROLE_USER_SN"))
    val user: Users? = null,

    @Column(name = "role", nullable = false)
    val role: String? = null,

    ) {
}