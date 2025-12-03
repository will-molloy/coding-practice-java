package com.willmolloy.adventofcode._2024

import com.willmolloy.adventofcode.common.Day
import com.willmolloy.adventofcode.common.Input
import com.willmolloy.adventofcode.common.grid.CharGrid
import com.willmolloy.adventofcode.common.grid.Direction

/** https://adventofcode.com/2024/day/15 */
object Day15 : Day(2024, 15) {

  override fun part1(input: Input): Any {
    val lines = input.readLines()
    val grid =
      CharGrid(lines.takeWhile { it.contains('#') }.map { it.toCharArray() }.toTypedArray())
        .toMutable()
    val moves =
      lines.dropWhile { it.contains('#') }.drop(1).flatMap { it.toList() }.map { mapDir(it) }

    var robot = grid.find { grid[it] == '@' }!!

    for (move in moves) {
      // break down into the various cases
      val next = robot.move(move)

      if (grid[next] == '.') {
        // facing empty space - robot moves
        grid[next] = '@'
        grid[robot] = '.'
        robot = next
      } else if (grid[next] == '#') {
        // facing a wall - can't move
      } else if (grid[next] == 'O') {
        // facing a box
        val nextNext = next.move(move)
        if (grid[nextNext] == '#') {
          // can't move box
        } else {
          // cascade all the boxes
          var afterLastBox = next
          while (grid[afterLastBox] == 'O') {
            afterLastBox = afterLastBox.move(move)
          }
          if (grid[afterLastBox] == '.') {
            // can move the boxes
            grid[afterLastBox] = 'O'
            // don't forget to move robot too
            grid[next] = '@'
            grid[robot] = '.'
            robot = next
          }
        }
      }
      // debug
      //      println("move: $move")
      //      println(grid)
      //      println()
    }

    return grid.filter { grid[it] == 'O' }.sumOf { it.x + it.y * 100 }
  }

  override fun part2(input: Input): Any {
    return 0
  }

  private fun mapDir(c: Char): Direction =
    when (c) {
      '^' -> Direction.UP
      '>' -> Direction.RIGHT
      'v' -> Direction.DOWN
      '<' -> Direction.LEFT
      else -> throw IllegalArgumentException("Unknown: $c")
    }
}
