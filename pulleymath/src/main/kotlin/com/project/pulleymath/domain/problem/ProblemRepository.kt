package com.project.pulleymath.domain.problem

import com.project.pulleymath.domain.problem.rqrs.ProblemRs
import com.project.pulleymath.domain.unitCode.UnitCode
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface ProblemRepository: JpaRepository<Problem, String>, ProblemCustomRepository {


}