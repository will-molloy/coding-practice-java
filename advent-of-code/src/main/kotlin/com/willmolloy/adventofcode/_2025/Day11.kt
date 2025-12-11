package com.willmolloy.adventofcode._2025

import com.willmolloy.adventofcode.common.Day
import com.willmolloy.adventofcode.common.Input
import com.willmolloy.adventofcode.common.extensions.debug
import java.util.BitSet

/** https://adventofcode.com/2025/day/11 */
object Day11 : Day(2025, 11) {

  private fun parseAdjList(input: Input): Map<String, List<String>> = buildMap {
    input.readLines().forEach { line ->
      val split = line.split(": ")
      put(split[0], split[1].split(" "))
    }
  }

  private fun toNodeIds(adjList: Map<String, List<String>>) = buildMap {
    var id = 0
    for (k in adjList.keys) {
      put(k, id++)
    }
    for (v in adjList.values.flatten()) {
      if (get(v) == null) {
        put(v, id++)
      }
    }
  }

  private fun toAdjListOfIds(adjList: Map<String, List<String>>, nodeIds: Map<String, Int>): Map<Int, IntArray> =
    adjList
      .mapKeys { nodeIds[it.key]!! }
      .mapValues { it.value.map { nodeIds[it]!! }.toIntArray() }

  override fun part1(input: Input): Any {
    // DFS count the paths...
    val adjList = parseAdjList(input)
    var count = 0

    // let's represent the nodes as ints instead...
    // doesn't improve algorithm complexity but might be enough?
    val nodeIds = toNodeIds(adjList)
    val adjListIds = toAdjListOfIds(adjList, nodeIds)
    nodeIds.size.debug()

    val end = nodeIds["out"]!!

    fun dfs(node: Int, path: BitSet) {
      if (node == end) {
        count++
        return
      }

      for (adjNode in adjListIds[node]!!) {
        if (!path.get(adjNode)) {
          path.set(adjNode)
          dfs(adjNode, path)
          path.clear(adjNode) // backtrack
        }
      }
    }

    dfs(nodeIds["you"]!!, BitSet())

    return count
  }

  override fun part2(input: Input): Any {
    // DFS count the paths...
    val adjList = parseAdjList(input)
    var count = 0

    // TODO very slow when the root is changed to "svr" :(
    // TODO is DP possible?? But we want all the paths, right?
    //  perhaps there's a way to prune based on the "contains" condition

//    fun dfs(node: String, path: MutableSet<String>) {
//      if (node == "out") {
//        if (path.contains("dac") && path.contains("fft")) {
//          count++
//        }
//        return
//      }
//
//      for (adjNode in adjList.getOrDefault(node, emptyList())) {
//        if (path.add(adjNode)) {
//          dfs(adjNode, path)
//          path.remove(adjNode) // backtrack
//        }
//      }
//    }
//
//    dfs("svr", mutableSetOf())

    // let's represent the nodes as ints instead...
    // doesn't improve algorithm complexity but might be enough?
    val nodeIds = toNodeIds(adjList)
    val adjListIds = toAdjListOfIds(adjList, nodeIds)
    nodeIds.size.debug()

    val end = nodeIds["out"]!!
    val contains1 = nodeIds["dac"]!!
    val contains2 = nodeIds["fft"]!!

    fun dfs(node: Int, path: BitSet) {
      if (node == end) {
        if (path.get(contains1) && path.get(contains2)) {
          count++
        }
        return
      }

      for (adjNode in adjListIds[node]!!) {
        if (!path.get(adjNode)) {
          path.set(adjNode)
          dfs(adjNode, path)
          path.clear(adjNode) // backtrack
        }
      }
    }

    dfs(nodeIds["svr"]!!, BitSet())

    return count
  }
}
