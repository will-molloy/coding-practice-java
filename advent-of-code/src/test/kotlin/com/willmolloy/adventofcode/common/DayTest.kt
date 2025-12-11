package com.willmolloy.adventofcode.common

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Assumptions.abort
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder

/**
 * Unit tests for [Day].
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
@TestMethodOrder(MethodOrderer.MethodName::class)
abstract class DayTest(private val day: Day) {
  private val exampleInput: FileInput = FileInput.example(day)
  private val realInput: FileInput? = FileInput.real(day)

  @Test
  fun part1_exampleInput() {
    val expected = part1().example.invoke()
    val actual = day.part1(exampleInput)
    assertThat(actual).isEqualTo(expected)
  }

  @Test
  fun part1_realInput() {
    val expected = part1().real.invoke()
    val actual = day.part1(realInput ?: abort())
    assertThat(actual).isEqualTo(expected)
  }

  @Test
  fun part2_exampleInput() {
    val expected = part2().example.invoke()
    val actual = day.part2(exampleInput)
    assertThat(actual).isEqualTo(expected)
  }

  @Test
  fun part2_realInput() {
    val expected = part2().real.invoke()
    val actual = day.part2(realInput ?: abort())
    assertThat(actual).isEqualTo(expected)
  }

  protected abstract fun part1(): Answer

  protected abstract fun part2(): Answer

  /**
   * Expected answer.
   *
   * @param example expected example answer
   * @param real expected real answer
   */
  data class Answer(val example: () -> Any, val real: () -> Any) {
    constructor(example: Any, real: Any) : this({ example }, { real })
  }
}
