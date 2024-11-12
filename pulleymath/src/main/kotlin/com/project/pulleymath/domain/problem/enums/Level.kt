package com.project.pulleymath.domain.problem.enums

/**
 * enum 설명
 *  - desc: 설명,
 *  - levels: 난이도,
 *  - ratio: 난이도 별 비율 (getLevelsForOrder 에 있는 순서대로이다.)
 *
 */
enum class Level(val desc: String, val levels: List<Long>, val ratio: List<Double>) {
  LOW("하", listOf(1), listOf(0.5, 0.3, 0.2)),
  MIDDLE("중", listOf(2, 3, 4), listOf(0.5, 0.25, 0.25)),
  HIGH("상", listOf(5), listOf(0.5, 0.3, 0.2));

  // 난이도 별 구할 순서를 지정한다.
  companion object {
    fun getLevelsForOrder(level: Level): List<Level> {
      return when (level) {
        LOW -> listOf(LOW, MIDDLE, HIGH)
        MIDDLE -> listOf(MIDDLE, LOW, HIGH)
        HIGH -> listOf(HIGH, MIDDLE, LOW)
      }
    }
  }
}
