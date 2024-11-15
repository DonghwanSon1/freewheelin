package com.project.pulleymath.domain.problem

import com.project.pulleymath.domain.unitCode.UnitCode
import javax.persistence.*

@Entity
@Table(name = "problem")
class Problem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sn")
    val sn: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = ForeignKey(name = "FK_PROBLEM_UNIT_CODE_SN"))
    val unitCode: UnitCode? = null,

    @Column(name = "level")
    val level: Long? = null,

    @Column(name = "type")
    val type: String? = null,

    @Column(name = "answer")
    val answer: Long? = null,
) {

    companion object {
        fun from(problemSn: Long): Problem {
            return Problem(sn = problemSn)
        }
    }
}