package com.project.pulleymath.domain.studentPiece

import com.project.pulleymath.domain.piece.Piece
import com.project.pulleymath.domain.problem.Problem
import com.project.pulleymath.domain.users.Users
import javax.persistence.*

@Entity
@Table(name = "student_piece")
class StudentPiece(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sn")
    val sn: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = ForeignKey(name = "FK_STUDENT_PIECE_PIECE_SN"))
    val piece: Piece? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_sn", foreignKey = ForeignKey(name = "FK_STUDENT_PIECE_STUDENT_SN"))
    val studentSn: Users? = null,

    @Column(name = "correct_rate")
    val correctRate: Int? = null,
) {
    companion object {
        fun createStudentPiece(piece: Piece, student: Users): StudentPiece {
            return StudentPiece(
                piece = piece,
                studentSn = student,
                correctRate = 0
            )
        }
    }
}