package com.project.pulleymath.domain.users

import com.fasterxml.jackson.annotation.JsonIgnore
import com.project.pulleymath.domain.users.rqrs.UserRq
import javax.persistence.*

@Entity
@Table(name = "users")
class Users(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sn")
    val sn: Long? = null,

    @Column(name = "id", unique = true, nullable = false)
    val id: String? = null,

    @JsonIgnore
    @Column(name = "password", nullable = false)
    val password: String? = null,

    @Column(name = "name", nullable = false)
    val name: String? = null,

) {

    companion object {
        fun createUser(userRq: UserRq, encryptedPassword: String): Users {
            return Users(
                id = userRq.id,
                password = encryptedPassword,
                name = userRq.name
            )
        }

        fun from(sn: Long): Users {
            return Users(sn = sn)
        }
    }
}