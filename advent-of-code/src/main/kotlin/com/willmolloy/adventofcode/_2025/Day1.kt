package com.willmolloy.adventofcode._2025

import com.willmolloy.adventofcode.common.Day
import com.willmolloy.adventofcode.common.Input

/** https://adventofcode.com/2025/day/1 */
object Day1 : Day(2025, 1) {

  override fun part1(input: Input) = solve(input).first

  override fun part2(input: Input) = solve(input).second

  private fun solve(input: Input): Pair<Int, Int> {
    val lines = input.readLines()

    var part1Res = 0
    // just move the res count into the inner loops...
    var part2Res = 0

    var dial = 50

    for (line in lines) {
      var nums = line.substring(1).toInt()

      when (line[0]) {
        'L' -> {
          // dec
          while (nums-- > 0) {
            dial--
            // TODO there must be a better way - modulo? But then part2 is broken...?
            if (dial == -1) {
              dial = 99
            }

            if (dial == 0) {
              part2Res++
            }
          }
        }
        'R' -> {
          // inc
          while (nums-- > 0) {
            dial++
            if (dial == 100) {
              dial = 0
            }

            if (dial == 0) {
              part2Res++
            }
          }
        }
      }

      if (dial == 0) {
        part1Res++
      }
    }

    return Pair(part1Res, part2Res)
  }
}
