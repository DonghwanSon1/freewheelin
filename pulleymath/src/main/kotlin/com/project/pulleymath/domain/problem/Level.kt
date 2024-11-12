package com.project.pulleymath.domain.problem

enum class Level(val desc: String, val levels: List<Long>) {
  LOW("하", listOf(1)),
  MIDDLE("중", listOf(2, 3, 4)),
  HIGH("상", listOf(5));
}
