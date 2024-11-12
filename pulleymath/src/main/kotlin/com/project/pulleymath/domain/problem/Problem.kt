package com.project.pulleymath.domain.problem

import com.project.pulleymath.domain.unitCode.UnitCode
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "PROBLEM")
data class Problem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sn")
    val sn: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_code_sn", referencedColumnName = "sn")
    val unitCode: UnitCode? = null,

    @Column(name = "level")
    val level: Long? = null,

    @Column(name = "type")
    val type: String? = null,

    @Column(name = "answer")
    val answer: Long? = null,
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