package com.willmolloy.adventofcode._2024

import com.willmolloy.adventofcode.common.grid.{Direction, Point}
import com.willmolloy.adventofcode.common.{Day, Input}
import com.willmolloy.adventofcode.scala.Adapters.ListAdapter
import com.willmolloy.adventofcode.scala.Adapters.GridAdapter

import scala.annotation.tailrec

/**
 * https://adventofcode.com/2024/day/4
 */
object Day4 extends Day(2024, 4) {

  override def part1(input: Input): Int = {
    val grid = input.readCharGrid()
    var count = 0

    @tailrec
    def dfs(point: Point, dir: Direction, i: Int): Unit = {
      if (i == "XMAS".length) {
        // covered it
        count += 1
        return
      }

      // check the prefix (individual chars) as we go
      if (!grid.inbounds(point) || grid(point) != "XMAS".charAt(i)) {
        return
      }

      dfs(point.move(dir), dir, i + 1)
    }

    for (point <- grid) {
      // search all directions
      for (dir <- Direction.straightAndDiagonal) {
        dfs(point, dir, 0)
      }
    }

    count
  }

  override def part2(input: Input): Int = {
    val grid = input.readCharGrid()
    grid
      // X-MAS must be centered on 'A'
      .filter(p => p.y >= 1 && p.x >= 1 && p.y < grid.height - 1 && p.x < grid.width - 1)
      .filter(p => grid(p) == 'A')
      .count(p => {
        val upLeft = grid(p.move(Direction.LEFT_UP))
        val upRight = grid(p.move(Direction.RIGHT_UP))
        val downLeft = grid(p.move(Direction.LEFT_DOWN))
        val downRight = grid(p.move(Direction.RIGHT_DOWN))

        List(Set(upLeft, downRight), Set(downLeft, upRight)).forall(_ == Set('M', 'S'))
      })
  }
}
