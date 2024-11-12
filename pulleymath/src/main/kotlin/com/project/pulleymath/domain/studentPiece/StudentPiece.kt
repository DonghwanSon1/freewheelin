package com.project.pulleymath.domain.studentPiece

import com.project.pulleymath.domain.piece.Piece
import com.project.pulleymath.domain.users.Users
import javax.persistence.*

@Entity
@Table(name = "student_piece")
data class StudentPiece(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sn")
    val sn: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = ForeignKey(name = "FK_STUDENT_PIECE_PIECE_SN"))
    val piece: Piece? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = ForeignKey(name = "FK_STUDENT_PIECE_STUDENT_SN"))
    val studentSn: Users? = null,

    @Column(name = "correct_rate")
    val correctRate: Int? = null,
    ) {
}