package com.project.pulleymath.domain.studentPieceAnswer

import org.springframework.data.jpa.repository.JpaRepository

interface StudentPieceAnswerRepository: JpaRepository<StudentPieceAnswer, String>, StudentPieceAnswerCustomRepository {

}