package com.project.pulleymath.domain.unitCode

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "unit_code")
data class UnitCode(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sn")
    val sn: Long? = null,

    @Column(name = "code")
    val code: String? = null,

    @Column(name = "name")
    val name: String? = null,

) {

//    companion object {
//        fun createCategory(categoryRq: CategoryRq): Problem {
//            return Problem(
//                name = categoryRq.name,
//                order = categoryRq.order ?: 0,
//                createdAt = LocalDateTime.now(),
//                updatedAt = LocalDateTime.now()
//            )
//        }
//    }
//
//    fun updateCategory(categoryRq: CategoryRq): Problem {
//        return Problem(
//            sn = this.sn,
//            name = categoryRq.name ?: this.name,
//            order = categoryRq.order ?: this.order,
//            createdAt = this.createdAt ?: LocalDateTime.now(),
//            updatedAt = LocalDateTime.now()
//        )
//    }
}