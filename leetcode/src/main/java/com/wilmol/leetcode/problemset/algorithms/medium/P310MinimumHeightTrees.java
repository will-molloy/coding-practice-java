package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a
 * href=https://leetcode.com/problems/minimum-height-trees>https://leetcode.com/problems/minimum-height-trees/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Answer is centre nodes. Can be at most 2. Trim layers of leaves until centre is left.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P310MinimumHeightTrees {

  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n <= 2) {
      return IntStream.range(0, n).boxed().collect(Collectors.toList());
    }

    // init graph
    Map<Integer, Set<Integer>> adjList = new LinkedHashMap<>();
    for (int[] edge : edges) {
      adjList.computeIfAbsent(edge[0], k -> new LinkedHashSet<>()).add(edge[1]);
      adjList.computeIfAbsent(edge[1], k -> new LinkedHashSet<>()).add(edge[0]);
    }

    // init leaves
    Set<Integer> leaves = new LinkedHashSet<>();
    for (int node = 0; node < n; node++) {
      if (adjList.get(node).size() == 1) {
        leaves.add(node);
      }
    }

    // trim leaves until 1 or 2 nodes left
    // i.e. tree forms layers from the centre
    // centre can have at most 2 nodes
    int nodesLeft = n;
    while (nodesLeft > 2) {
      nodesLeft -= leaves.size();

      Set<Integer> newLeaves = new LinkedHashSet<>();
      for (int leaf : leaves) {
        for (int adj : adjList.get(leaf)) {
          // remove edge to leaf
          adjList.get(adj).remove(leaf);
          if (adjList.get(adj).size() == 1) {
            // adj is leaf at the next layer
            newLeaves.add(adj);
          }
        }
      }
      leaves = newLeaves;
    }

    return List.copyOf(leaves);
  }
}
