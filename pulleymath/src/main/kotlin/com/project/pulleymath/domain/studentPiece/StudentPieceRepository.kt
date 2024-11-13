package com.project.pulleymath.domain.studentPiece

import com.project.pulleymath.domain.piece.Piece
import org.springframework.data.jpa.repository.JpaRepository

interface StudentPieceRepository: JpaRepository<StudentPiece, String>, StudentPieceCustomRepository {

  fun findByPiece(piece: Piece): List<StudentPiece>?
}