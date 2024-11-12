package com.project.pulleymath.domain.problem

import com.project.pulleymath.domain.problem.enums.Type
import com.project.pulleymath.domain.problem.rqrs.ProblemRs


interface ProblemCustomRepository {

  fun findByUnitCode(unitCodeSnList: List<Long>, problemType: Type): MutableList<ProblemRs>
//    fun findAllCategory(): List<CategoryRs>
}