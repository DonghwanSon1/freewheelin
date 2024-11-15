package com.project.pulleymath.domain.pieceProblem.rqrs

import com.fasterxml.jackson.annotation.JsonIgnore
import io.swagger.v3.oas.annotations.media.Schema

data class PieceProblemAnalyzeRs(
    @Schema(description = "문제 sn")
    val problemSn: Long? = null,

    @JsonIgnore
    @Schema(description = "맞춘 정답 개수")
    val problemCorrectCount: Int? = null,

    @Schema(description = "학생들의 문제 당 정답률")
    val problemCorrectRate: Int? = null,

){
    fun calculateCorrectRate(totalCount: Double): PieceProblemAnalyzeRs {
        return PieceProblemAnalyzeRs(
            problemSn = this.problemSn,
            problemCorrectCount = this.problemCorrectCount,
            problemCorrectRate = ((problemCorrectCount!! / totalCount) * 100).toInt()
        )
    }
}
