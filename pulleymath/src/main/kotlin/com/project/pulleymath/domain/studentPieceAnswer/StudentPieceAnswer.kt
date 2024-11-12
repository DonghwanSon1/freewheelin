package com.project.pulleymath.domain.studentPieceAnswer

import com.project.pulleymath.domain.piece.Piece
import com.project.pulleymath.domain.problem.Problem
import javax.persistence.*

@Entity
@Table(name = "student_piece_problem_answer")
data class StudentPieceAnswer(
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

    @Column(name = "student_answer")
    val studentAnswer: Long? = null,

    @Column(name = "grading")
    val grading: Boolean? = null,
    ) {
}