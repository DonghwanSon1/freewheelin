package com.project.pulleymath.domain.piece

import com.project.pulleymath.domain.users.entity.Users
import javax.persistence.*

@Entity
@Table(name = "piece")
data class Piece(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sn")
    val sn: Long? = null,

    @Column(name = "name", nullable = false)
    val name: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_sn", referencedColumnName = "sn", nullable = false)
    val createdBy: Users? = null,

    ) {

//    companion object {
//        fun createCategory(categoryRq: CategoryRq): Problem {
//            return Problem(
//                name = categoryRq.name,
//                order = categoryRq.order ?: 0,
//                createdAt = LocalDateTime.now(),
//                updatedAt = LocalDateTime.now()
//            )
//        }
//    }
//
//    fun updateCategory(categoryRq: CategoryRq): Problem {
//        return Problem(
//            sn = this.sn,
//            name = categoryRq.name ?: this.name,
//            order = categoryRq.order ?: this.order,
//            createdAt = this.createdAt ?: LocalDateTime.now(),
//            updatedAt = LocalDateTime.now()
//        )
//    }
}