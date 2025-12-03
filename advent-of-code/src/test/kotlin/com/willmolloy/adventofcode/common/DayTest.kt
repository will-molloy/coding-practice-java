package com.willmolloy.adventofcode.common

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Assumptions.abort
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.extension.ExtendWith

/**
 * Unit tests for [Day].
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
abstract class DayTest(private val day: Day) {
  private val exampleInput: FileInput = FileInput.example(day)
  private val realInput: FileInput? = FileInput.real(day)

  @Order(1)
  @Test
  fun part1_exampleInput() {
    assertThat(day.part1(exampleInput)).isEqualTo(part1().example)
  }

  @Order(3)
  @Test
  fun part1_realInput() {
    assertThat(day.part1(realInput ?: abort())).isEqualTo(part1().real)
  }

  @Order(2)
  @Test
  fun part2_exampleInput() {
    assertThat(day.part2(exampleInput)).isEqualTo(part2().example)
  }

  @Order(4)
  @Test
  fun part2_realInput() {
    assertThat(day.part2(realInput ?: abort())).isEqualTo(part2().real)
  }

  protected abstract fun part1(): Answer

  protected abstract fun part2(): Answer

  /**
   * Expected answer.
   *
   * @param example expected example answer
   * @param real expected real answer
   */
  data class Answer(val example: Any, val real: Any)
}
