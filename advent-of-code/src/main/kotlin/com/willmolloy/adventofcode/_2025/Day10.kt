package com.willmolloy.adventofcode._2025

import com.willmolloy.adventofcode.common.Day
import com.willmolloy.adventofcode.common.Input
import com.willmolloy.adventofcode.common.extensions.debug
import java.util.BitSet
import java.util.concurrent.atomic.AtomicInteger

/** https://adventofcode.com/2025/day/10 */
object Day10 : Day(2025, 10) {

  private class Machine(
    val lights: BooleanArray,
    val buttons: Array<IntArray>,
    val joltage: IntArray,
  ) {
    override fun toString(): String {
      return "Machine(lights=${lights.contentToString()}, buttons=${buttons.contentDeepToString()}, joltage=${joltage.contentToString()})"
    }
  }

  private fun parse(input: Input): List<Machine> =
    input.readLines().map { line ->
      val match = Regex("\\[(.*)] \\((.*)\\) \\{(.*)}").matchEntire(line)!!
      val (lights, buttons, joltage) = match.destructured

      val lightsTyped = lights.toCharArray().map { it != '.' }.toBooleanArray()
      val buttonsTyped =
        buttons.split(") (").map { it.split(",").map { it.toInt() }.toIntArray() }.toTypedArray()
      val joltageTyped = joltage.split(",").map { it.toInt() }.toIntArray()
      Machine(lightsTyped, buttonsTyped, joltageTyped)
    }

  fun BooleanArray.toBitSet(): BitSet {
    val bitSet = BitSet()
    for ((i, b) in this.withIndex()) {
      if (b) {
        bitSet.flip(i)
      }
    }
    return bitSet
  }

  override fun part1(input: Input): Any {
    val machines = parse(input)
    val solveCount = AtomicInteger()

    fun solve(machine: Machine): Long {
      "Solving ${solveCount.incrementAndGet()}/${machines.size}: $machine".debug()

      // represent the graph node as a bitset; otherwise get OOM
      val lightsBitSet = machine.lights.toBitSet()

      // BFS for shorted path
      val queue = ArrayDeque<BitSet>()

      // initially all lights off
      val root = BitSet()
      queue.add(root)

      val visited = mutableSetOf<BitSet>()

      var depth = 0L
      while (!queue.isEmpty()) {
        "Depth: $depth, breadth: ${queue.size}".debug()

        (0..<queue.size).forEach { _ ->
          val node = queue.removeFirst()

          if (node == lightsBitSet) {
            return depth
          }

          for (button in machine.buttons) {
            val adjNode = node.clone() as BitSet

            // TODO possible to represent button as BitSet then flip all at once?
            button.forEach { adjNode.flip(it) }

            if (visited.add(adjNode)) {
              queue.add(adjNode)
            }
          }
        }
        depth++
      }

      error("Failed to solve: $machine")
    }

    return machines.sumOf { solve(it) }
  }

  override fun part2(input: Input): Any {
    val machines = parse(input)
    val solveCount = AtomicInteger()

    fun solve(machine: Machine): Long {
      "Solving ${solveCount.incrementAndGet()}/${machines.size}: $machine".debug()

      // TODO possible to represent the joltage as bitset too?
      // TODO or is there a more efficient way to traverse the graph?
      // TODO the subreddit mentions Z3...

      // BFS for shorted path
      val queue = ArrayDeque<IntArray>()

      // initially all joltage zero
      val root = IntArray(machine.joltage.size) { 0 }
      queue.add(root)

      val visited = mutableSetOf<String>()

      var depth = 0L
      while (!queue.isEmpty()) {
        "Depth: $depth, breadth: ${queue.size}".debug()

        (0..<queue.size).forEach { _ ->
          val node = queue.removeFirst()

          if (node.contentEquals(machine.joltage)) {
            return depth
          }

          for (button in machine.buttons) {
            val adjNode = node.clone()

            button.forEach { adjNode[it]++ }

            // prune nodes which exceed the joltage
            if (adjNode.withIndex().any { adjNode[it.index] > machine.joltage[it.index] }) {
              continue
            }

            if (visited.add(adjNode.contentToString())) {
              queue.add(adjNode)
            }
          }
        }
        depth++
      }

      error("Failed to solve: $machine")
    }

    return machines.sumOf { solve(it) }
  }
}
