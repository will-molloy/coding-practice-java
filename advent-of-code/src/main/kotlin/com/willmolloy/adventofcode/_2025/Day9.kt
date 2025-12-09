package com.willmolloy.adventofcode._2025

import com.willmolloy.adventofcode.common.Day
import com.willmolloy.adventofcode.common.Input
import com.willmolloy.adventofcode.common.extensions.pairs
import com.willmolloy.adventofcode.common.extensions.size
import com.willmolloy.adventofcode.common.grid.Point
import kotlin.collections.lastIndex
import kotlin.math.max
import kotlin.math.min

/** https://adventofcode.com/2025/day/9 */
object Day9 : Day(2025, 9) {

  override fun part1(input: Input): Any {
    val redTiles = getRedTiles(input)

    fun area(p1: Point, p2: Point): Long {
      val cols = min(p1.x, p2.x)..max(p1.x, p2.x)
      val rows = min(p1.y, p2.y)..max(p1.y, p2.y)
      return cols.size * rows.size
    }

    return redTiles.pairs().maxOf { area(it.first, it.second) }
  }

  override fun part2(input: Input): Long {
    val redTiles = getRedTiles(input)
    val greenTiles = getGreenTilesLoop(redTiles)
    val redGreenTiles = redTiles.union(greenTiles)

    // "In addition, all the tiles inside this loop of red and green tiles are also green."
    // ROW -> COL RANGE
    val tiledRanges =
      redGreenTiles
        .groupBy { it.y }
        .mapValues { (_, tiles) -> tiles.minOf { it.x }..tiles.maxOf { it.x } }

    fun area(p1: Point, p2: Point): Long {
      val cols = min(p1.x, p2.x)..max(p1.x, p2.x)
      val rows = min(p1.y, p2.y)..max(p1.y, p2.y)

      for (row in rows) {
        val tiledRange = tiledRanges[row] ?: return 0L
        if (tiledRange.start > cols.start || tiledRange.endInclusive < cols.endInclusive) {
          return 0L
        }
      }

      return cols.size * rows.size
    }

    return redTiles.pairs().maxOf { area(it.first, it.second) }
  }

  private fun getRedTiles(input: Input): List<Point> =
    input.readLines().map {
      val split = it.split(",")
      Point(split[0], split[1])
    }

  private fun getGreenTilesLoop(redTiles: List<Point>): List<Point> = buildList {
    for (i in 0 until redTiles.size) {
      val point = redTiles[i]
      val adjPoint = if (i < redTiles.lastIndex) redTiles[i + 1] else redTiles[0]

      // "Tiles that are adjacent will always be on either the same row or the same column."
      if (point.x == adjPoint.x) {
        // same col
        for (y in min(point.y, adjPoint.y)..max(point.y, adjPoint.y)) {
          add(Point(point.x, y))
        }
      } else {
        // same row
        for (x in min(point.x, adjPoint.x)..max(point.x, adjPoint.x)) {
          add(Point(x, point.y))
        }
      }
    }
  }
}
