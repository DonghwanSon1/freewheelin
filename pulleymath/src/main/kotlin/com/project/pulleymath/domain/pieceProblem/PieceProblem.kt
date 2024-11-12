package com.project.pulleymath.domain.pieceProblem

import com.project.pulleymath.domain.piece.Piece
import com.project.pulleymath.domain.problem.Problem
import com.project.pulleymath.domain.users.Users
import javax.persistence.*

@Entity
@Table(name = "piece_problem")
data class PieceProblem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sn")
    val sn: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = ForeignKey(name = "FK_PIECE_PROBLEM_PIECE_SN"))
    val piece: Piece? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = ForeignKey(name = "FK_PIECE_PROBLEM_PROBLEM_SN"))
    val problem: Problem? = null,

) {
    companion object {
        fun createPieceProblem(piece: Piece, problem: Problem): PieceProblem {
            return PieceProblem(
                piece = piece,
                problem = problem
            )
        }
    }
}