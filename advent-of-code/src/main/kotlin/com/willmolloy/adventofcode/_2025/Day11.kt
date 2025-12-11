package com.willmolloy.adventofcode._2025

import com.willmolloy.adventofcode.common.Day
import com.willmolloy.adventofcode.common.Input

/** https://adventofcode.com/2025/day/11 */
object Day11 : Day(2025, 11) {

  private fun parse(input: Input) = buildMap {
    input.readLines().forEach { line ->
      val split = line.split(": ")
      val source = split[0]
      val dest = split[1].split(" ")
      put(source, dest)
    }
  }

  override fun part1(input: Input): Any {
    // DFS count the paths...
    val adjList = parse(input)
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
    val adjList = parse(input)

    val dp = mutableMapOf<String, Long>()

    fun dfs(node: String, path: String): Long {
      val key = path + node

      val cached = dp[key]
      if (cached != null) {
        return cached
      }

      if (node == "out") {
        if (path.contains("dac") && path.contains("fft")) {
          return 1
        }
        return 0
      }

      var count = 0L

      for (adjNode in adjList.getOrDefault(node, emptyList())) {
        var newPath = path
        // only add the nodes we're interested in... otherwise the lookup times it out
        if (adjNode == "dac" || adjNode == "fft") {
          newPath += adjNode
        }
        count += dfs(adjNode, newPath)
      }

      dp[key] = count
      return count
    }

    return dfs("svr", "")
  }
}
