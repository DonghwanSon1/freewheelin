package com.project.pulleymath.domain.pieceProblem.rqrs

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.project.pulleymath.domain.problem.Problem
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

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

//    companion object {
//        fun of(studentSn: Long?, studentName: String?, pieceCorrectRate: Int?): PieceProblemAnalyzeRs {
//            return PieceProblemAnalyzeRs(
//                studentSn = studentSn,
//                studentName = studentName,
//                pieceCorrectRate = pieceCorrectRate
//            )
//        }
//    }
}
