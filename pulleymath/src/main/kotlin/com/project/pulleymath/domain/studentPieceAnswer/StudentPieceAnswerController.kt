package com.project.pulleymath.domain.studentPieceAnswer

import com.project.pulleymath.domain.studentPiece.StudentPieceService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/student-piece-answer")
@Tag(name = "StudentPieceAnswer", description = "학생 학습지 관련 API")
class StudentPieceAnswerController(
    private val studentPieceAnswerService: StudentPieceAnswerService
) {

}