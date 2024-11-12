package com.project.pulleymath.domain.studentPiece

import com.project.pulleymath.domain.piece.Piece
import com.project.pulleymath.domain.users.entity.Users
import org.springframework.beans.factory.parsing.Problem
import javax.persistence.*

@Entity
@Table(name = "student_piece")
data class StudentPiece(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sn")
    val sn: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "piece_sn", referencedColumnName = "sn", nullable = false)
    val piece: Piece? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_sn", referencedColumnName = "sn", nullable = false)
    val studentSn: Users? = null,

    @Column(name = "correct_rate")
    val correctRate: Int? = null,
    ) {
}