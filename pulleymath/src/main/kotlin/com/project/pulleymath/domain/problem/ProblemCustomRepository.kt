package com.project.pulleymath.domain.problem

import com.project.pulleymath.domain.category.rqrs.CategoryRs
import com.project.pulleymath.domain.problem.rqrs.ProblemRs
import com.project.pulleymath.domain.unitCode.UnitCode


interface ProblemCustomRepository {

  fun findByUnitCode(unitCodeSnList: List<Long>, problemType: Type): MutableList<ProblemRs>
//    fun findAllCategory(): List<CategoryRs>
}