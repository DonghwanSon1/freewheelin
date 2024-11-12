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
    @JoinColumn(name = "created_by", foreignKey = ForeignKey(name = "FK_PIECE_CREATED_BY"))
    val createdBy: Users? = null,

    ) {

    companion object {
        fun createPiece(name: String, user: Users): Piece {
            return Piece(
                name = name,
                createdBy = user
            )
        }
    }
}