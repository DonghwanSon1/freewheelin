package com.project.pulleymath.domain.studentPiece.rqrs

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

data class StudentPieceRs(
    @Schema(description = "학생 학습지 sn")
    val studentPieceSn: Long? = null,

    @Schema(description = "학습지 이름")
    val pieceName: String? = null,

    @Schema(description = "학습지 생성자 (선생님) 이름")
    val teacherName: String? = null,

    @Schema(description = "학생 학습지의 정답률")
    val correctRate: Int? = null,
)
