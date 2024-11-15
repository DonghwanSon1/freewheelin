package com.project.pulleymath.domain.piece.rqrs

import com.project.pulleymath.domain.pieceProblem.rqrs.PieceProblemAnalyzeRs
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

data class PieceAnalyzeRs(
    @Schema(description = "학습지 sn")
    val pieceSn: Long? = null,

    @Schema(description = "학습지 이름")
    val pieceName: String? = null,

    @Schema(description = "출제한 학생들 목록 및 데이터 담을 리스트")
    val studentAnalyzeList: List<PieceStudentAnalyzeRs>? = null,

    @Schema(description = "학습지 문제 리스트")
    val pieceProblemList: List<PieceProblemAnalyzeRs>? = null,

    ){
    companion object {
        fun of(pieceSn: Long, pieceName: String, studentAnalyzeList: List<PieceStudentAnalyzeRs>, pieceProblemList: List<PieceProblemAnalyzeRs>): PieceAnalyzeRs {
            return PieceAnalyzeRs(
                pieceSn = pieceSn,
                pieceName = pieceName,
                studentAnalyzeList = studentAnalyzeList,
                pieceProblemList = pieceProblemList
            )
        }
    }
}
