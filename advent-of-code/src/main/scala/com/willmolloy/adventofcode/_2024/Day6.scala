package com.willmolloy.adventofcode._2024

import com.willmolloy.adventofcode.common.grid.{Direction, MutableCharGrid, Point}
import com.willmolloy.adventofcode.common.{Day, Input}
import com.willmolloy.adventofcode.scala.Adapters.ListAdapter
import com.willmolloy.adventofcode.scala.Adapters.GridAdapter
import com.willmolloy.adventofcode.scala.Adapters.MutableGridAdapter

import scala.annotation.tailrec
import scala.collection.mutable

/**
 * https://adventofcode.com/2024/day/6
 */
object Day6 extends Day(2024, 6) {

  override def part1(input: Input): Int = {
    val grid = input.readCharGrid().toMutable
    val visited = mutable.Set[Point]()

    @tailrec
    def dfs(point: Point): Unit = {
      visited.add(point)

      val dir = grid(point)
      val next = point.move(mapDir(dir))

      if (!grid.inbounds(next)) {
        // out
        return
      } else if (grid(next) == '.') {
        // move forward
        grid(next) = dir
        grid(point) = '.'
        dfs(next)
      } else if (grid(next) == '#') {
        // turn 90deg
        grid(point) = nextDir(dir)
        dfs(point)
      }
    }

    // find start
    val start = grid
      .find(point => Set('>', '<', '^', 'V').contains(grid(point)))
      .get

    dfs(start)

    visited.size
  }

  override def part2(input: Input): Int = {
    val grid = input.readCharGrid()

    // find start
    val start = grid
      .find(point => Set('>', '<', '^', 'V').contains(grid(point)))
      .get

    import scala.collection.parallel.CollectionConverters.ImmutableSeqIsParallelizable

    // try obstacle in all positions
    grid
      .filter(point => grid(point) == '.')
//      .par
      .count(point => {
        val copy = grid.toMutable
        copy(point) = '#'
        looping(copy, start)
      })
  }

  private def looping(grid: MutableCharGrid, start: Point): Boolean = {
    // how to define looping?
    // 1 - it passes through the starting position? No - it can still leave
    // 2 - it creates a square - 5th turn is in last 4 turns? No - it can loop NOT in a square
    // 3 - ??? how about if turns = grid size. That is at least an upper bound...
    // 4 - it makes the same turn -> same point AND direction.
    val turns = mutable.Set[(Point, Direction)]()

    @tailrec
    def dfs(point: Point): Boolean = {
      val dir = grid(point)
      val next = point.move(mapDir(dir))

      if (!grid.inbounds(next)) {
        // out
        false
      } else if (grid(next) == '.') {
        // move forward
        grid(next) = dir
        grid(point) = '.'
        dfs(next)
      } else if (grid(next) == '#') {
        // looping if a turn is repeated
        if (!turns.add((point, mapDir(dir)))) {
          return true
        }

        // turn 90deg
        grid(point) = nextDir(dir)
        dfs(point)
      } else {
        false
      }
    }

    dfs(start)
  }

  private def mapDir(dir: Char): Direction = dir match {
    case '^' => Direction.UP
    case '>' => Direction.RIGHT
    case 'V' => Direction.DOWN
    case '<' => Direction.LEFT
  }

  private def nextDir(dir: Char): Char = dir match {
    case '^' => '>'
    case '>' => 'V'
    case 'V' => '<'
    case '<' => '^'
  }
}
