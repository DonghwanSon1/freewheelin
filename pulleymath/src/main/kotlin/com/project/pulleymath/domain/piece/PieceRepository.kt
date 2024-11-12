package com.project.pulleymath.domain.piece

import org.springframework.data.jpa.repository.JpaRepository

interface PieceRepository: JpaRepository<Piece, String>, PieceCustomRepository {

//  fun findByUnitCode(unitCode: UnitCode): List<ProblemRs>
//    fun findBySnIn(sn: List<Long>): List<Category>
//    fun findBySn(categorySn: Long): Category?

//    @Modifying
//    @Query("  DELETE FROM Category c WHERE c.sn IN :snList")
//    fun deleteBySnList(snList: List<Long>)

}