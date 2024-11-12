package com.project.pulleymath.domain.studentPieceAnswer


import com.project.pulleymath.domain.studentPiece.StudentPieceRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class StudentPieceAnswerService(
    private val studentPieceAnswerRepository: StudentPieceAnswerRepository
) {
}