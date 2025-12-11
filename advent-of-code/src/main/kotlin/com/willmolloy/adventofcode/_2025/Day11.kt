package com.willmolloy.adventofcode._2025

import com.willmolloy.adventofcode.common.Day
import com.willmolloy.adventofcode.common.Input

/** https://adventofcode.com/2025/day/11 */
object Day11 : Day(2025, 11) {

  override fun part1(input: Input): Any {
    // DFS count the paths...

    val adjList = mutableMapOf<String, List<String>>()

    input.readLines().forEach { line ->
      val split = line.split(": ")
      val source = split[0]
      val dest = split[1].split(" ")
      adjList[source] = dest
    }

    var count = 0

    fun dfs(node: String, path: MutableSet<String>) {
      if (node == "out") {
        count++
        return
      }

      for (adjNode in adjList.getOrDefault(node, emptyList())) {
        if (path.add(adjNode)) {
          dfs(adjNode, path)
          path.remove(adjNode) // backtrack
        }
      }
    }

    dfs("you", mutableSetOf())

    return count
  }

  override fun part2(input: Input): Any {
    // DFS count the paths...

    val adjList = mutableMapOf<String, List<String>>()

    input.readLines().forEach { line ->
      val split = line.split(": ")
      val source = split[0]
      val dest = split[1].split(" ")
      adjList[source] = dest
    }

    var count = 0

    fun dfs(node: String, path: MutableSet<String>) {
      if (node == "out") {
        if (path.contains("dac") && path.contains("fft")) {
          count++
        }
        return
      }

      for (adjNode in adjList.getOrDefault(node, emptyList())) {
        if (path.add(adjNode)) {
          dfs(adjNode, path)
          path.remove(adjNode) // backtrack
        }
      }
    }

    dfs("svr", mutableSetOf())

    return count
  }
}
