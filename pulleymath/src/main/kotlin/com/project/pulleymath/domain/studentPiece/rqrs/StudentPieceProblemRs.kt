package com.project.pulleymath.domain.studentPiece.rqrs

import com.project.pulleymath.domain.problem.Problem
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

data class StudentPieceProblemRs(
    @Schema(description = "문제 유형코드")
    val unitCode: String? = null,

    @Schema(description = "문제 유형코드 이름")
    val unitCodeName: String? = null,

    @Schema(description = "문제 리스트")
    val problemList: List<StudentPieceProblemDetailRs>? = null

){
    companion object {
        fun of(unitCode: String, unitCodeName: String, problemList: List<StudentPieceProblemDetailRs>): StudentPieceProblemRs {
            return StudentPieceProblemRs(
                unitCode = unitCode,
                unitCodeName = unitCodeName,
                problemList = problemList
            )
        }
    }
}
