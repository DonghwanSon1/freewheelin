package com.project.pulleymath.domain.problem

import org.springframework.data.jpa.repository.JpaRepository

interface ProblemRepository: JpaRepository<Problem, Long>, ProblemCustomRepository {


}