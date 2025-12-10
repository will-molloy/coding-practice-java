package com.willmolloy.adventofcode._2025

import com.willmolloy.adventofcode.common.Day
import com.willmolloy.adventofcode.common.Input
import com.willmolloy.adventofcode.common.extensions.debug
import java.util.concurrent.atomic.AtomicInteger

/** https://adventofcode.com/2025/day/10 */
object Day10 : Day(2025, 10) {

  // lights = BITSET
  private class Machine(val lights: Int, val buttons: Array<IntArray>, val joltage: IntArray){
    override fun toString(): String {
      return "Machine(lights=${lights}, buttons=${buttons.contentDeepToString()}, joltage=${joltage.contentToString()})"
    }
  }

  fun Int.toggleBit(bit: Int): Int = this xor (1 shl bit)

  override fun part1(input: Input): Any {
    val machines = parse(input)

    val solve = AtomicInteger(0)

    fun solve(machine: Machine): Long {
      "Solving ${solve.incrementAndGet()}/${machines.size}: $machine".debug()

      // BFS for shorted path
      val queue = ArrayDeque<Int>()

      // initially all off
      queue.add(0)

      val visited = mutableSetOf<Int>()

      var depth = 0L
      while (!queue.isEmpty()) {

        val levelSize = queue.size
        for (i in 0 until levelSize) {
          val node = queue.removeFirst()

          if (node == machine.lights) {
            return depth
          }

          for (button in machine.buttons.withIndex()) {
            var adjNode = node
            for (b in button.value) {
              adjNode = adjNode.toggleBit(b)
            }

            if (visited.add(adjNode)) {
              queue.add(adjNode)
            }
          }

        }
        depth++
      }

      error("Unsolved")
    }

    return machines.sumOf { solve(it) }
  }

  override fun part2(input: Input): Any {
    return 2222222222222222
  }

  private fun parse(input: Input): List<Machine> = input.readLines()
    .mapNotNull { line ->
      val match = Regex("\\[(.*)](.*)\\{(.*)}").matchEntire(line) ?: return@mapNotNull null

      val (lights, buttons, joltage) = match.destructured

      val lightsTyped = lights.toCharArray().map { it != '.' }.toBooleanArray()

      val buttonsTyped = buttons.trim().removePrefix("(").removeSuffix(")").split(") (")
        .map { it.split(",").map { it.toInt() }.toIntArray() }.toTypedArray()

      val joltageTyped = joltage.split(",").map { it.toInt() }.toIntArray()

      var lightsBits = 0
      for ((i, b) in lightsTyped.withIndex()) {
        if (b) {
          lightsBits = lightsBits.toggleBit(i)
        }
      }

      Machine(lightsBits, buttonsTyped, joltageTyped)
    }
}
