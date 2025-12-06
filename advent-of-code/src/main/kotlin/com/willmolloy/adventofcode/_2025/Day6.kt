package com.willmolloy.adventofcode._2025

import com.willmolloy.adventofcode.common.Day
import com.willmolloy.adventofcode.common.Input
import com.willmolloy.adventofcode.common.debug
import com.willmolloy.adventofcode.common.transpose

/** https://adventofcode.com/2025/day/6 */
object Day6 : Day(2025, 6) {

  override fun part1(input: Input): Any {
    val nums =
      input.readLines().dropLast(1).map { it.trim().split(Regex("\\s+")).map { it.toLong() } }

    val ops = input.readLines().last().trim().split(Regex("\\s+"))

    var total = 0L
    for (col in 0 until nums.first().size) {
      val add = ops[col] == "+"

      var res = if (add) 0L else 1L

      for (row in 0 until nums.size) {
        if (add) {
          res += nums[row][col]
        } else {
          res *= nums[row][col]
        }
      }

      total += res
    }

    return total
  }

  override fun part2(input: Input): Any {
    val ops = input.readLines().last().trim().split(Regex("\\s+"))

    /*
     * 123 328  51 64
     *  45 64  387 23
     *   6 98  215 314
     * *   +   *   +
     */
    // read as grid and transpose?
    /*
     * 356
     * 24
     * 1
     */
    // yeah it works...

    val grid = input.readLines().dropLast(1).map { it.split("") }

    val transpose = grid.transpose()

    val nums = transpose.map { list -> list.filter { it.isNotBlank() }.joinToString("") }.debug()
    // the numbers are now grouped, with empty string separating them in the list

    var total = 0L
    var numsI = 1
    for (op in ops) {
      val add = op == "+"

      var res = if (add) 0L else 1L

      while (numsI < nums.size) {
        val num = nums[numsI++]
        if (num.isEmpty()) {
          break
        }

        if (add) {
          res += num.toLong()
        } else {
          res *= num.toLong()
        }
      }

      total += res
    }
    return total
  }
}
