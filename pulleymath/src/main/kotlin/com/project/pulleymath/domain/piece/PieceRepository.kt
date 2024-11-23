package com.project.pulleymath.domain.piece

import com.project.pulleymath.domain.users.Users
import org.springframework.data.jpa.repository.JpaRepository

interface PieceRepository: JpaRepository<Piece, Long>, PieceCustomRepository {


}