package com.project.pulleymath.domain.studentPiece

import com.project.pulleymath.domain.piece.Piece
import com.project.pulleymath.domain.users.Users
import org.springframework.data.jpa.repository.JpaRepository

interface StudentPieceRepository: JpaRepository<StudentPiece, String>, StudentPieceCustomRepository {

  fun findByPiece(piece: Piece): List<StudentPiece>?
  fun findBySnAndStudentSn(studentPieceSn: Long, student: Users): StudentPiece?

}