package com.project.pulleymath.domain.unitCode

import javax.persistence.*

@Entity
@Table(name = "unit_code")
class UnitCode(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sn")
    val sn: Long? = null,

    @Column(name = "code")
    val code: String? = null,

    @Column(name = "name")
    val name: String? = null,

) {

}