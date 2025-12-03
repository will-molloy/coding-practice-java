package com.willmolloy.adventofcode._2024

import com.willmolloy.adventofcode.common.Day
import com.willmolloy.adventofcode.common.Input
import com.willmolloy.adventofcode.common.grid.CharGrid
import com.willmolloy.adventofcode.common.grid.Direction
import com.willmolloy.adventofcode.common.grid.Point

/** https://adventofcode.com/2024/day/12 */
object Day12 : Day(2024, 12) {

  override fun part1(input: Input): Any {
    val grid = input.readCharGrid()
    return regions(grid).sumOf { region ->
      val a = region.size
      val p = perimeter(region)
      a * p
    }
  }

  override fun part2(input: Input): Any {
    val grid = input.readCharGrid()
    return regions(grid).sumOf { region ->
      val a = region.size
      val s = sides(region)
      a * s
    }
  }

  // TODO this can be a method on Grid.
  private fun regions(grid: CharGrid): Set<Set<Point>> {
    val visited = mutableSetOf<Point>()

    fun dfs(current: Point, region: MutableSet<Point>) {
      visited.add(current)
      region.add(current)

      for (dir in Direction.straight()) {
        val next = current.move(dir)
        if (grid.inbounds(next) && !visited.contains(next) && grid[next] == grid[current]) {
          dfs(next, region)
        }
      }
    }

    val regions = mutableSetOf<Set<Point>>()
    for (point in grid) {
      if (!visited.contains(point)) {
        val region = mutableSetOf<Point>()
        dfs(point, region)
        regions.add(region)
      }
    }
    return regions
  }

  private fun perimeter(region: Set<Point>): Int {
    // just count how many neighbours are outside the region
    // alternatively: perimeter = area * 4 - inner_edges (my original idea...)
    var perimeter = 0

    for (point in region) {
      for (direction in Direction.straight()) {
        val next = point.move(direction)
        if (!region.contains(next)) {
          perimeter++
        }
      }
    }
    return perimeter
  }

  private fun sides(region: Set<Point>): Int {
    // sides = corners
    // TODO not 100% why this needs to be a set (i.e. why it counts some corners multiple times)
    val corners = mutableSetOf<Set<Point>>()

    for (point in region) {
      val left = point.move(Direction.LEFT)
      val right = point.move(Direction.RIGHT)
      val up = point.move(Direction.UP)
      val down = point.move(Direction.DOWN)
      if (!region.contains(left) && !region.contains(up)) {
        corners.add(setOf(left, up))
      }
      if (!region.contains(left) && !region.contains(down)) {
        corners.add(setOf(left, down))
      }
      if (!region.contains(right) && !region.contains(up)) {
        corners.add(setOf(right, up))
      }
      if (!region.contains(right) && !region.contains(down)) {
        corners.add(setOf(right, down))
      }
    }

    val negativeCorners = mutableSetOf<Set<Point>>()
    for (point in region) {
      for (outsidePoint in
        Direction.straight().map { point.move(it) }.filter { !region.contains(it) }) {
        val left = outsidePoint.move(Direction.LEFT)
        val right = outsidePoint.move(Direction.RIGHT)
        val up = outsidePoint.move(Direction.UP)
        val down = outsidePoint.move(Direction.DOWN)
        if (region.contains(left) && region.contains(up)) {
          negativeCorners.add(setOf(left, up))
        }
        if (region.contains(left) && region.contains(down)) {
          negativeCorners.add(setOf(left, down))
        }
        if (region.contains(right) && region.contains(up)) {
          negativeCorners.add(setOf(right, up))
        }
        if (region.contains(right) && region.contains(down)) {
          negativeCorners.add(setOf(right, down))
        }
      }
    }
    return corners.size + negativeCorners.size
  }
}
