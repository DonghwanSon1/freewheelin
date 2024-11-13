package com.project.pulleymath.domain.studentPiece

import com.project.pulleymath.domain.studentPiece.rqrs.StudentPieceRs
import com.project.pulleymath.domain.users.Users


interface StudentPieceCustomRepository {
  fun searchStudentPiece(users: Users): List<StudentPieceRs>?

}