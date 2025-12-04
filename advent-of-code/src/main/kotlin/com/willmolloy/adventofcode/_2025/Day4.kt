package com.willmolloy.adventofcode._2025

import com.willmolloy.adventofcode.common.Day
import com.willmolloy.adventofcode.common.Input
import com.willmolloy.adventofcode.common.grid.CharGrid
import com.willmolloy.adventofcode.common.grid.Direction
import com.willmolloy.adventofcode.common.grid.Point

/** https://adventofcode.com/2025/day/4 */
object Day4 : Day(2025, 4) {

  override fun part1(input: Input): Any {
    val grid = input.readCharGrid()

    return grid.filter { grid[it] == '@' }.count { canRemove(grid, it) }
  }

  override fun part2(input: Input): Any {
    val grid = input.readCharGrid().toMutable()

    while (true) {
      var removed = 0

      for (point in grid.filter { grid[it] == '@' }) {
        if (canRemove(grid, point)) {
          grid[point] = 'x'
          removed++
        }
      }

      if (removed == 0) {
        break
      }
    }

    return grid.points().count { grid[it] == 'x' }
  }

  private fun canRemove(grid: CharGrid, point: Point): Boolean {
    val adjPaper =
      Direction.straightAndDiagonal().count {
        val adjPoint = point.move(it)
        grid.inbounds(adjPoint) && grid[adjPoint] == '@'
      }
    return adjPaper < 4
  }
}
