package com.project.pulleymath.domain.pieceProblem

import org.springframework.data.jpa.repository.JpaRepository

interface PieceProblemRepository: JpaRepository<PieceProblem, String>, PieceProblemCustomRepository {

}