package com.project.pulleymath.domain.studentPiece

import com.project.pulleymath.domain.pieceProblem.dto.PieceProblemDto
import com.project.pulleymath.domain.studentPiece.rqrs.StudentPieceRs
import com.project.pulleymath.domain.users.Users


interface StudentPieceCustomRepository {
  fun searchStudentPiece(student: Users): List<StudentPieceRs>?
  fun searchPieceProblem(studentPieceSn: Long, student: Users): List<PieceProblemDto>?

}