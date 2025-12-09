package com.willmolloy.adventofcode._2025

import com.willmolloy.adventofcode.common.Day
import com.willmolloy.adventofcode.common.Input
import com.willmolloy.adventofcode.common.extensions.debug
import com.willmolloy.adventofcode.common.extensions.size
import com.willmolloy.adventofcode.common.grid.Point
import kotlin.collections.lastIndex
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/** https://adventofcode.com/2025/day/9 */
object Day9 : Day(2025, 9) {

  override fun part1(input: Input): Any {
    val redTiles = getRedTiles(input)

    var max = 0L

    for ((i, p1) in redTiles.withIndex()) {
      for (p2 in redTiles.drop(i + 1)) {
        val area = (abs(p2.y - p1.y) + 1) * (abs(p2.x - p1.x) + 1)
        max = max(max, area)
      }
    }

    return max
  }

  private fun getRedTiles(input: Input): List<Point> =
    input.readLines().map {
      val split = it.split(",")
      Point(split[0], split[1])
    }

  private fun getLoopOfGreenTiles(redTiles: List<Point>): List<Point> {
    val greenTiles = mutableListOf<Point>()

    for (i in 0 until redTiles.size) {
      val point = redTiles[i]
      val adjPoint = if (i < redTiles.lastIndex) redTiles[i + 1] else redTiles[0]
      // "Tiles that are adjacent will always be on either the same row or the same column."
      if (point.x == adjPoint.x) {
        // same col
        for (y in min(point.y, adjPoint.y)..max(point.y, adjPoint.y)) {
          greenTiles.add(Point(point.x, y))
        }
      } else {
        // same row
        for (x in min(point.x, adjPoint.x)..max(point.x, adjPoint.x)) {
          greenTiles.add(Point(x, point.y))
        }
      }
    }

    return greenTiles
  }

  override fun part2(input: Input): Any {
    val redTiles = getRedTiles(input)
    val greenTiles = getLoopOfGreenTiles(redTiles)
    val redGreenTiles = redTiles.union(greenTiles)

    // "In addition, all the tiles inside this loop of red and green tiles are also green."
    val rowStart = redGreenTiles.minOf { it.y }
    val rowEnd = redGreenTiles.maxOf { it.y }
    println("ROWS = $rowStart..$rowEnd")

    // ROW -> COL RANGE
    val tiledRanges = mutableMapOf<Long, LongRange>()

    for (row in rowStart..rowEnd) {
      val tilesInRow = redGreenTiles.filter { it.y == row }
      if (tilesInRow.isEmpty()) {
        continue
      }

      val colStart = tilesInRow.minOf { it.x }
      val colEnd = tilesInRow.maxOf { it.x }

      tiledRanges[row] = colStart..colEnd
    }

    tiledRanges.debug()

    fun area(p1: Point, p2: Point): Long {
      // no need to filter for topLeft/bottomRight points because all the points in the rectangle
      // are checked that they're tiled - so just force topLeft/bottomRight:
      val cols = min(p1.x, p2.x)..max(p1.x, p2.x)
      val rows = min(p1.y, p2.y)..max(p1.y, p2.y)

      for (row in rows) {
        val tiledRange = tiledRanges[row] ?: return 0L
        if (tiledRange.start > cols.start) {
          return 0L
        }
        if (tiledRange.endInclusive < cols.endInclusive) {
          return 0L
        }
      }

      return cols.size * rows.size
    }

    // "The rectangle you choose still must have red tiles in opposite corners"
    var max = 0L

    for ((i, p1) in redTiles.withIndex()) {
      for (p2 in redTiles.drop(i + 1)) {
        val area = area(p1, p2)
        if (area > max) {
          max = area
          println("NEW MAX: $p1 and $p2 = $area")
        }
      }
    }

    return max
  }
}
