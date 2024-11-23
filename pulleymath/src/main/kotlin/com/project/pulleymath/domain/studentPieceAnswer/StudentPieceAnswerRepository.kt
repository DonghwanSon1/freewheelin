package com.project.pulleymath.domain.studentPieceAnswer

import com.project.pulleymath.domain.studentPiece.StudentPiece
import org.springframework.data.jpa.repository.JpaRepository

interface StudentPieceAnswerRepository: JpaRepository<StudentPieceAnswer, Long> {

  fun findByStudentPiece(studentPiece: StudentPiece): List<StudentPieceAnswer>?

}