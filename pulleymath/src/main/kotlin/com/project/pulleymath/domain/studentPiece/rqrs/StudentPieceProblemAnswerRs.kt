package com.project.pulleymath.domain.studentPiece.rqrs

import io.swagger.v3.oas.annotations.media.Schema

data class StudentPieceProblemAnswerRs(
    @Schema(description = "총 문제수")
    val totalProblemCount: Int = 0,

    @Schema(description = "할당된 학습지에 채점된 수")
    val gradingCount: Int = 0,

    @Schema(description = "맞은 개수")
    val correctCount: Int = 0,

    @Schema(description = "정답률")
    val correctRate: Int = 0,

){
    companion object {
        fun of(totalProblemCount: Int, gradingCount: Int, correctCount: Int)
        : StudentPieceProblemAnswerRs {
            return StudentPieceProblemAnswerRs(
                totalProblemCount = totalProblemCount,
                gradingCount = gradingCount,
                correctCount = correctCount,
                correctRate = ((correctCount / totalProblemCount.toDouble()) * 100).toInt()
            )
        }
    }
}
