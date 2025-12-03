package com.willmolloy.adventofcode._2024

import com.willmolloy.adventofcode.common.grid.Point
import com.willmolloy.adventofcode.common.{Day, Input}
import com.willmolloy.adventofcode.scala.Adapters.ListAdapter
import com.willmolloy.adventofcode.scala.Adapters.GridAdapter

import scala.collection.mutable
import scala.util.boundary
import scala.util.boundary.break

/**
 * https://adventofcode.com/2024/day/8
 */
object Day8 extends Day(2024, 8) {

  override def part1(input: Input): Long = {
    val grid = input.readCharGrid()
    val nodes = mutable.Set[Point]()

    for (p1 <- grid) {
      for (p2 <- grid) {
        // 2 antenna
        if (p1 != p2 && grid(p1) == grid(p2) && grid(p1) != '.') {
          // math
          val dx = Math.abs(p1.x - p2.x)
          val dy = Math.abs(p1.y - p2.y)

          val x3 = if p1.x < p2.x then p1.x - dx else p1.x + dx
          val y3 = if p1.y < p2.y then p1.y - dy else p1.y + dy
          val p3 = Point(x3, y3)
          if (grid.inbounds(p3)) {
            nodes.add(p3)
          }
        }
      }
    }
    nodes.size
  }

  override def part2(input: Input): Long = {
    val grid = input.readCharGrid()
    val nodes = mutable.Set[Point]()

    for (p1 <- grid) {
      for (p2 <- grid) {
        // 2 antenna
        if (p1 != p2 && grid(p1) == grid(p2) && grid(p1) != '.') {
          // math
          val dx = Math.abs(p1.x - p2.x)
          val dy = Math.abs(p1.y - p2.y)

          var m = 0
          boundary {
            while (true) {
              val x3 = if p1.x < p2.x then p1.x - dx * m else p1.x + dx * m
              val y3 = if p1.y < p2.y then p1.y - dy * m else p1.y + dy * m
              val p3 = Point(x3, y3)
              m += 1
              if (grid.inbounds(p3)) {
                nodes.add(p3)
              } else {
                break()
              }
            }
          }
        }
      }
    }
    nodes.size
  }
}
