package com.willmolloy.adventofcode._2025

import com.willmolloy.adventofcode.common.Day
import com.willmolloy.adventofcode.common.Input
import kotlin.math.max

/** https://adventofcode.com/2025/day/3 */
object Day3 : Day(2025, 3) {

  override fun part1(input: Input): Any{
    var res = 0

    for (line in input.lines()) {
      // try all the combos...
      var lineMax = 0
      for (i in 0 until line.length) {
        for (j in i + 1 until line.length) {
          val num = line[i].digitToInt() * 10 + line[j].digitToInt()
          lineMax = max(lineMax, num)
        }
      }

      res += lineMax
    }
    return res
  }

  override fun part2(input: Input): Any {
    // same but go to a depth of 12 rather than 2... thinking dfs
    // dfs too slow...
    // instead it can be greedy?? how?

    var res = 0L

    for (line in input.lines()) {
      var maxSum = 0L

      fun dfs(i: Int, turnedOn: Int, limit: Int, sum: Long){
        if (turnedOn == limit) {
          maxSum = max(maxSum, sum)
          return
        }

        for (j in i + 1 until line.length) {
          val nextSum = sum * 10 + line[j].digitToInt()
          dfs(j, turnedOn + 1, limit, nextSum)
        }
      }

      dfs(-1, 0, 12, 0)

      println("Max for: $line = $maxSum")
      res += maxSum
    }
    return res
  }
}
