package com.project.pulleymath.domain.studentPiece.rqrs

import com.fasterxml.jackson.annotation.JsonInclude
import io.swagger.v3.oas.annotations.media.Schema

data class StudentPieceProblemDetailRs(
    @Schema(description = "문제 sn")
    val problemSn: Long? = null,

    @Schema(description = "문제 난이도")
    val level: Long? = null,

    @Schema(description = "문제 유형")
    val type: String? = null,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "학생 답안 sn")
    val studentAnswerSn: Long? = null,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "학생 답안 (제출한 답안)")
    val studentAnswer: Long? = null,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "정답 여부")
    val grading: Boolean? = null,

){
    companion object {
        fun of(problemSn: Long, level: Long, type: String, studentAnswerSn: Long?, studentAnswer: Long?, grading: Boolean?): StudentPieceProblemDetailRs {
            return StudentPieceProblemDetailRs(
                problemSn = problemSn,
                level = level,
                type = type,
                studentAnswerSn = studentAnswerSn,
                studentAnswer = studentAnswer,
                grading = grading
            )
        }
    }
}
