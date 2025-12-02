package com.willmolloy.adventofcode._2025

import com.willmolloy.adventofcode.common.Day
import com.willmolloy.adventofcode.common.Input

/** https://adventofcode.com/2025/day/2 */
object Day2 : Day(2025, 2) {

  override fun part1(input: Input) =
    solve(input) { id -> id.take(id.length / 2) == id.drop(id.length / 2) }

  override fun part2(input: Input) =
    solve(input) { id ->
      ((1..id.length / 2).any { chunkSize ->
        val chunked = id.chunked(chunkSize)
        chunked.all { s -> s == chunked.first() }
      })
    }

  private fun solve(input: Input, test: (String) -> Boolean): Long {
    val ranges = input.string().split(",")

    var res = 0L

    for (range in ranges) {
      val start = range.split("-")[0].toLong()
      val end = range.split("-")[1].toLong()

      for (id in start..end) {
        if (test(id.toString())) {
          res += id
        }
      }
    }

    return res
  }
}
