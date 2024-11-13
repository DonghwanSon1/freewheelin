package com.project.pulleymath.domain.piece

import com.project.pulleymath.domain.users.Users
import org.springframework.data.jpa.repository.JpaRepository

interface PieceRepository: JpaRepository<Piece, String>, PieceCustomRepository {

  fun findBySn(pieceSn: Long): Piece?

//  fun findByUnitCode(unitCode: UnitCode): List<ProblemRs>
//    fun findBySnIn(sn: List<Long>): List<Category>
//    fun findBySn(categorySn: Long): Category?

//    @Modifying
//    @Query("  DELETE FROM Category c WHERE c.sn IN :snList")
//    fun deleteBySnList(snList: List<Long>)

}