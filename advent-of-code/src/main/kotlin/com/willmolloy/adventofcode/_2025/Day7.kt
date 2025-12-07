package com.willmolloy.adventofcode._2025

import com.willmolloy.adventofcode.common.Day
import com.willmolloy.adventofcode.common.Input
import com.willmolloy.adventofcode.common.debug
import com.willmolloy.adventofcode.common.grid.CharGrid
import com.willmolloy.adventofcode.common.grid.Direction
import com.willmolloy.adventofcode.common.grid.Grid
import com.willmolloy.adventofcode.common.grid.Point

/** https://adventofcode.com/2025/day/7 */
object Day7 : Day(2025, 7) {

  override fun part1(input: Input): Any {
    val grid = getFinalGrid(input)

    // number of spits
    return grid.filter { grid[it] == '^' }.count {
      val up = it.move(Direction.UP)
      grid.inbounds(up) && grid[up] == '|'
    }
  }

  override fun part2(input: Input): Any {
    // number of paths - DFS / DP?

    /*
     * .......S.......
     * .......40.......
     * .......^.......
     * .......25.15.....
     * .....17^8^7.....
     * .....17.8.7.....
     * ....10^7^1^6....
     * ....10.7...6....
     * ...5^5^2.2^4...
     * ...5.5...2.4...
     * ..4^1^4.1^1^3..
     * ..4...4...1.3..
     * .2^2.2^2..11^2.
     * .2.2.2.2.211.2.
     * 1^1^1^1^1^111^1
     * ...............
     */

    val grid = getFinalGrid(input).debug()

    val dp = Array(grid.height()) { LongArray(grid.width()) { 0L } }

    for (col in 0 until grid.width()) {
      val row = grid.height() - 1
      val p = Point(col.toLong(), row.toLong())
      if (grid[p] == '|') {
        dp[row][col] = 1
      }
    }
    dp.joinToString("\n") { it.joinToString("") }.debug()

    for (row in grid.height() - 2 downTo 0) {
      for (col in 0 until grid.width()) {
        val p = Point(col.toLong(), row.toLong())
        val down = p.move(Direction.DOWN)

        if (grid[down] == '|') {
          dp[row][col] = dp[row + 1][col]
        } else if (grid[down] == '^') {
          // sum
          dp[row][col] = dp[row + 1][col - 1] + dp[row + 1][col + 1]
        }
      }

      dp.joinToString("\n") { it.joinToString("") }.debug()
    }

    val start = grid.find { grid[it] == 'S' }!!
    return dp[start.y.toInt()][start.x.toInt()]
  }

  private fun getFinalGrid(input: Input): CharGrid {
    var grid = input.readCharGrid()

    while (true) {
      var changed = false

      val nextGrid = grid.toMutable()

      for (point in grid) {
        if (grid[point] == 'S' || grid[point] == '|') {
          // go down
          val down = point.move(Direction.DOWN)
          if (grid.inbounds(down)) {
            if (grid[down] == '^') {
              // split

              val left = down.move(Direction.LEFT)
              if (grid.inbounds(left) && grid[left] == '.') {
                nextGrid[left] = '|'
                changed = true
              }

              val right = down.move(Direction.RIGHT)
              if (grid.inbounds(right) && grid[left] == '.') {
                nextGrid[right] = '|'
                changed = true
              }
            } else {
              if (grid[down] == '.') {
                // simply go down
                nextGrid[down] = '|'
                changed = true
              }
            }
          }
        }
      }

      grid = nextGrid

      if (!changed) {
        break
      }
    }

    return grid
  }
}
