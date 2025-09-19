package com.willmolloy.adventofcode.common

/**
 * A day in the advent-of-code calendar.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
abstract class Day(val year: Int, val day: Int) {
  init {
    require(year >= 2015) { "Invalid year: $year" }
    require(day in 1..25) { "Invalid day: $day" }
  }

  abstract fun part1(input: Input): Any

  abstract fun part2(input: Input): Any

  override fun toString(): String = "Day[$year, $day]"
}
