package com.willmolloy.adventofcode._2025

import com.willmolloy.adventofcode.common.Day
import com.willmolloy.adventofcode.common.Input
import com.willmolloy.adventofcode.common.datastructures.DisjointSet
import com.willmolloy.adventofcode.common.extensions.product
import com.willmolloy.adventofcode.common.grid.Point3
import java.util.Comparator.comparingLong
import java.util.PriorityQueue

/** https://adventofcode.com/2025/day/8 */
object Day8 : Day(2025, 8) {

  override fun part1(input: Input): Any = solve(input).first

  override fun part2(input: Input): Any = solve(input).second

  private fun solve(input: Input): Pair<Long, Long> {
    // some MST problem
    val points =
      input.readLines().map {
        val split = it.split(",")
        Point3(split[0], split[1], split[2])
      }

    val circuits = DisjointSet(points.size)

    val edges =
      PriorityQueue<Pair<Int, Int>>(comparingLong { points[it.first].dist(points[it.second]) })
    for (src in 0 until points.size) {
      for (dst in src + 1 until points.size) {
        edges.add(src to dst)
      }
    }

    val maxConnections = if (edges.size > 1000) 1000 else 10
    var part1 = 0L
    var part2 = 0L

    for (connections in 0 until edges.size) {
      val edge = edges.remove()

      val src = edge.first
      val dst = edge.second

      circuits.union(src, dst)

      if (connections == maxConnections - 1) {
        val top3 = circuits.sizes().sortedDescending().map { it.toLong() }.take(3)
        part1 = top3.product()
      }

      if (circuits.size(src) == points.size) {
        part2 = (points[src].x * points[dst].x)
        break
      }
    }

    return Pair(part1, part2)
  }
}
