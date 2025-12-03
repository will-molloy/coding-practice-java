package com.willmolloy.adventofcode._2024

import com.willmolloy.adventofcode.common.grid.{Direction, CharGrid, Point}
import com.willmolloy.adventofcode.common.{Day, Input}
import com.willmolloy.adventofcode.scala.Adapters.ListAdapter
import com.willmolloy.adventofcode.scala.Adapters.GridAdapter

import scala.collection.mutable

/**
 * https://adventofcode.com/2024/day/10
 */
object Day10 extends Day(2024, 10) {

  override def part1(input: Input): Long = {
    val grid = input.readCharGrid()
    grid.filter(grid(_) == '0').map(score(grid, _)).sum
  }

  private def score(grid: CharGrid, start: Point): Long = {
    val reach = mutable.Set[Point]()

    def dfs(current: Point): Unit = {
      if (grid(current) == '9') {
        reach.add(current)
        return
      }

      for (dir <- Direction.straight) {
        val next = current.move(dir, 1)
        if (grid.inbounds(next) && grid(next) == grid(current) + 1) {
          dfs(next)
        }
      }
    }

    dfs(start)
    reach.size
  }

  override def part2(input: Input): Long = {
    val grid = input.readCharGrid()
    grid.filter(grid(_) == '0').map(rating(grid, _)).sum
  }

  private def rating(grid: CharGrid, start: Point): Long = {
    val paths = mutable.Set[Seq[Point]]()

    def dfs(path: Seq[Point]): Unit = {
      val current = path.last
      if (grid(current) == '9') {
        paths.add(path)
        return
      }

      for (dir <- Direction.straight) {
        val next = current.move(dir, 1)
        if (grid.inbounds(next) && grid(next) == grid(current) + 1) {
          dfs(path :+ next)
        }
      }
    }

    dfs(Seq(start))
    paths.size
  }
}
