package com.project.pulleymath.domain.studentPiece

import org.springframework.data.jpa.repository.JpaRepository

interface StudentPieceRepository: JpaRepository<StudentPiece, String>, StudentPieceCustomRepository {

}