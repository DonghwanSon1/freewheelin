package com.project.pulleymath.domain.piece

import com.project.pulleymath.domain.users.Users
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
    @JoinColumn(foreignKey = ForeignKey(name = "FK_PIECE_CREATED_BY"))
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