package com.project.pulleymath.domain.problem

import com.project.pulleymath.domain.problem.rqrs.ProblemRs
import com.project.pulleymath.domain.unitCode.UnitCode
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface ProblemRepository: JpaRepository<Problem, String>, ProblemCustomRepository {

//  fun findByUnitCode(unitCode: UnitCode): List<ProblemRs>
//    fun findBySnIn(sn: List<Long>): List<Category>
//    fun findBySn(categorySn: Long): Category?

//    @Modifying
//    @Query("  DELETE FROM Category c WHERE c.sn IN :snList")
//    fun deleteBySnList(snList: List<Long>)

}