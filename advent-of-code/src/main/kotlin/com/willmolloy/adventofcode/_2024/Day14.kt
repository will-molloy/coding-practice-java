package com.willmolloy.adventofcode._2024

import com.willmolloy.adventofcode.common.Day
import com.willmolloy.adventofcode.common.Input
import com.willmolloy.adventofcode.common.grid.BoundedPoint
import com.willmolloy.adventofcode.common.grid.CharGrid

/** https://adventofcode.com/2024/day/14 */
object Day14 : Day(2024, 14) {

  private data class Robot(var p: BoundedPoint, val dx: Long, val dy: Long)

  private fun parseInput(input: Input): List<Robot> {
    val robots =
      input.readLines().map { line ->
        // TODO lib for parsing into data class
        val (x, y, dx, dy) =
          Regex("p=(\\d+),(\\d+) v=(-?\\d+),(-?\\d+)").matchEntire(line)!!.destructured
        Robot(BoundedPoint(x.toLong(), y.toLong()), dx.toLong(), dy.toLong())
      }
    val maxX = robots.maxOf { it.p.x } + 1
    val maxY = robots.maxOf { it.p.y } + 1
    return robots.map { Robot(it.p.withBound(maxX, maxY), it.dx, it.dy) }
  }

  override fun part1(input: Input): Any {
    val robots = parseInput(input)
    val xBound = robots.first().p.xBound
    val yBound = robots.first().p.yBound

    repeat(100) {
      for (robot in robots) {
        robot.p = robot.p.move(robot.dx, robot.dy)
      }
    }

    var q1 = 0
    var q2 = 0
    var q3 = 0
    var q4 = 0
    for (robot in robots) {
      if (robot.p.x < xBound / 2 && robot.p.y < yBound / 2) {
        q1++
      }
      if (robot.p.x > xBound / 2 && robot.p.y < yBound / 2) {
        q2++
      }
      if (robot.p.x < xBound / 2 && robot.p.y > yBound / 2) {
        q3++
      }
      if (robot.p.x > xBound / 2 && robot.p.y > yBound / 2) {
        q4++
      }
    }
    return q1 * q2 * q3 * q4
  }

  override fun part2(input: Input): Any {
    val robots = parseInput(input)
    val xBound = robots.first().p.xBound
    val yBound = robots.first().p.yBound

    val tree =
      """
            ^
           ^^^
          ^^^^^
         ^^^^^^^
            ^
      """
        .trimIndent()
    val treePoints =
      CharGrid(tree.split("\n").map { it.toCharArray() }.toTypedArray()).map {
        BoundedPoint(it.x, it.y, xBound, yBound)
      }

    fun isTree(): Boolean {
      val robotPoints = robots.map { it.p }.toSet()
      return robotPoints.any { offset ->
        treePoints.all { treePoint -> robotPoints.contains(treePoint.move(offset.x, offset.y)) }
      }
    }

    var i = 0
    while (!isTree() && i < 100_000) {
      i++
      for (robot in robots) {
        robot.p = robot.p.move(robot.dx, robot.dy)
      }
    }
    return i
  }
}
