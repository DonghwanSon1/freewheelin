package com.project.pulleymath.domain.users

import com.project.pulleymath.domain.users.rqrs.UserRq
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
    companion object {
        fun createUser(userRq: UserRq): Users {
            return Users(
                id = userRq.id,
                password = userRq.password,
                name = userRq.name
            )
        }
    }
}