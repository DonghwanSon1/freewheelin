package com.project.pulleymath.domain.studentPieceAnswer

import com.project.pulleymath.domain.problem.Problem
import com.project.pulleymath.domain.studentPiece.StudentPiece
import javax.persistence.*

@Entity
@Table(name = "student_piece_problem_answer")
class StudentPieceAnswer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sn")
    val sn: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = ForeignKey(name = "FK_STUDENT_PIECE_PROBLEM_ANSWER_STUDENT_PIECE_SN"))
    val studentPiece: StudentPiece? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = ForeignKey(name = "FK_STUDENT_PIECE_PROBLEM_ANSWER_PROBLEM_SN"))
    val problem: Problem? = null,

    @Column(name = "student_answer")
    val studentAnswer: Long? = null,

    @Column(name = "grading")
    val grading: Boolean? = null,

) {
    companion object {
        fun createStudentPieceAnswer(studentPieceSn: Long, problemSn: Long, studentAnswer: Long, grading: Boolean): StudentPieceAnswer {
            return StudentPieceAnswer(
                studentPiece = StudentPiece.from(studentPieceSn),
                problem = Problem.from(problemSn),
                studentAnswer = studentAnswer,
                grading = grading
            )
        }
    }

    fun update(studentAnswer: Long, grading: Boolean): StudentPieceAnswer {
        return StudentPieceAnswer(
            sn = this.sn,
            studentPiece = this.studentPiece,
            problem = this.problem,
            studentAnswer = studentAnswer,
            grading = grading
        )
    }
}