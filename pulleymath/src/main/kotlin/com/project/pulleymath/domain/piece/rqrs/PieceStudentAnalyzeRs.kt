package com.project.pulleymath.domain.piece.rqrs

import com.fasterxml.jackson.annotation.JsonInclude
import io.swagger.v3.oas.annotations.media.Schema

data class PieceStudentAnalyzeRs(
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "학생 sn")
    val studentSn: Long? = null,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "학생 이름")
    val studentName: String? = null,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "출제한 학생들의 학습지 정답률")
    val pieceCorrectRate: Int? = null,
){
    companion object {
        fun of(studentSn: Long?, studentName: String?, pieceCorrectRate: Int?): PieceStudentAnalyzeRs {
            return PieceStudentAnalyzeRs(
                studentSn = studentSn,
                studentName = studentName,
                pieceCorrectRate = pieceCorrectRate
            )
        }
    }
}
