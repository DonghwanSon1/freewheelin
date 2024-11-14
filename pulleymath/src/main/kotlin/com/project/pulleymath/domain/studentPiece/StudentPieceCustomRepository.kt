package com.project.pulleymath.domain.studentPiece

import com.project.pulleymath.domain.studentPiece.dto.StudentPieceProblemDto
import com.project.pulleymath.domain.studentPiece.rqrs.StudentPieceRs
import com.project.pulleymath.domain.users.Users


interface StudentPieceCustomRepository {
  fun searchStudentPiece(student: Users): List<StudentPieceRs>?
  fun searchStudentPieceProblem(studentPieceSn: Long, student: Users): List<StudentPieceProblemDto>?

}