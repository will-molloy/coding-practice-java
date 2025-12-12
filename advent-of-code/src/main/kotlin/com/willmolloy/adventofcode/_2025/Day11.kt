package com.willmolloy.adventofcode._2025

import com.willmolloy.adventofcode.common.Day
import com.willmolloy.adventofcode.common.Input
import com.willmolloy.adventofcode.common.extensions.debug

/** https://adventofcode.com/2025/day/11 */
object Day11 : Day(2025, 11) {

  private fun parse(input: Input): Map<String, List<String>> = buildMap {
    input.readLines().forEach { line ->
      val split = line.split(": ")
      val source = split[0]
      val dest = split[1].split(" ")
      put(source, dest)
    }
  }

  override fun part1(input: Input): Any {
    // DFS -> count all paths
    val adjList = parse(input)
    var count = 0

    // no need for 'visited' check (cycle detection) as the graph is a DAG:
    // https://i.redd.it/vhr676hdbm6g1.png

    fun dfs(node: String) {
      if (node == "out") {
        count++
        return
      }

      for (adjNode in adjList.getOrDefault(node, emptyList())) {
        dfs(adjNode)
      }
    }

    dfs("you")
    return count
  }

  override fun part2(input: Input): Any {
    // DFS -> count all paths
    val adjList = parse(input)

    // the graph in part 1 ("you" to "out") is a lot smaller compared to now ("svr" to "out"):
    // https://i.redd.it/vhr676hdbm6g1.png
    // by using DP we can essentially create "checkpoints" whenever we see "fft" / "dac" and cache
    // the number of paths beyond them

    val dp = mutableMapOf<Triple<String, Boolean, Boolean>, Long>()

    fun dfs(node: String, seenDac: Boolean, seenFft: Boolean): Long {
      val key = Triple(node, seenDac, seenFft)
      val cached = dp[key]
      if (cached != null) {
        return cached
      }

      if (node == "out") {
        return if (seenDac && seenFft) 1 else 0
      }

      var count = 0L

      for (adjNode in adjList.getOrDefault(node, emptyList())) {
        val seenDac = seenDac || adjNode == "dac"
        val seenFft = seenFft || adjNode == "fft"
        count += dfs(adjNode, seenDac, seenFft)
      }

      dp[key] = count
      return count
    }

    return dfs("svr", seenDac = false, seenFft = false).also { dp.debug() }
  }
}
