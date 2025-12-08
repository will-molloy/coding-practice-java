package com.willmolloy.adventofcode._2025

import com.willmolloy.adventofcode.common.Day
import com.willmolloy.adventofcode.common.Input
import java.util.Comparator.comparingLong

/** https://adventofcode.com/2025/day/8 */
object Day8 : Day(2025, 8) {

  private data class Point(val x: Long, val y: Long, val z: Long) {
    override fun toString(): String = "${x},${y},${z}"
  }

  private class DisjointSet(val parent: IntArray, val size: IntArray) {
    constructor(numNodes: Int) : this(IntArray(numNodes) { it }, IntArray(numNodes) { 1 })

    fun union(src: Int, dst: Int): Boolean {
      val srcSet = find(src)
      val dstSet = find(dst)

      if (srcSet == dstSet) {
        return false
      }

      parent[dstSet] = srcSet
      size[srcSet] += size[dstSet]
      size[dstSet] = 0

      return true
    }

    fun find(node: Int): Int {
      if (parent[node] != node) {
        parent[node] = find(parent[node])
      }
      return parent[node]
    }
  }

  private fun dist(p: Point, q: Point): Long =
    (p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y) + (p.z - q.z) * (p.z - q.z)

  override fun part1(input: Input): Any = solve(input).first

  override fun part2(input: Input): Any = solve(input).second

  private fun solve(input: Input): Pair<Long, Long> {
    // some MST problem
    val points =
      input.readLines().map {
        val split = it.split(",")
        Point(split[0].toLong(), split[1].toLong(), split[2].toLong())
      }

    val disjointSet = DisjointSet(points.size)

    val edges = mutableListOf<Pair<Int, Int>>()
    for (src in 0 until points.size) {
      for (dst in src + 1 until points.size) {
        edges.add(src to dst)
      }
    }
    edges.sortWith(comparingLong { dist(points[it.first], points[it.second]) })

    val toJoin = if (edges.size > 1000) 1000 else 10
    var part1 = 0L
    var part2 = 0L

    for (i in 0 until edges.size) {
      val edge = edges[i]

      val src = edge.first
      val dst = edge.second

      disjointSet.union(src, dst)

      if (i == toJoin - 1) {
        val top3 = disjointSet.size.sortedDescending().take(3)
        part1 = top3.reduce { a, b -> a * b }.toLong()
      }

      if (disjointSet.size[src] == points.size) {
        part2 = (points[src].x * points[dst].x)
        break
      }
    }

    return part1 to part2
  }
}
