package com.project.pulleymath.domain.studentPiece.rqrs

import com.project.pulleymath.domain.piece.Piece
import com.project.pulleymath.domain.studentPiece.StudentPiece
import com.project.pulleymath.domain.users.Users
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

data class StudentPieceProblemAnswerRs(
    @Schema(description = "총 문제수")
    val totalProblemCount: Int = 0,

    @Schema(description = "제출한 답안 수")
    val studentAnswerCount: Int = 0,

    @Schema(description = "맞은 개수")
    val correctCount: Int = 0,

    @Schema(description = "정답률")
    val correctRate: Int = 0,

){
    companion object {
        fun of(totalProblemCount: Int, studentAnswerCount: Int, correctCount: Int)
        : StudentPieceProblemAnswerRs {
            return StudentPieceProblemAnswerRs(
                totalProblemCount = totalProblemCount,
                studentAnswerCount = studentAnswerCount,
                correctCount = correctCount,
                correctRate = ((correctCount / totalProblemCount.toDouble()) * 100).toInt()
            )
        }
    }
}
