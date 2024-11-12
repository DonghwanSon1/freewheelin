package com.project.pulleymath.domain.pieceProblem

import com.project.pulleymath.domain.piece.Piece
import org.springframework.beans.factory.parsing.Problem
import javax.persistence.*

@Entity
@Table(name = "piece_problem")
data class PieceProblem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sn")
    val sn: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "piece_sn", referencedColumnName = "sn", nullable = false)
    val piece: Piece? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_sn", referencedColumnName = "sn", nullable = false)
    val problem: Problem? = null,

    ) {
}