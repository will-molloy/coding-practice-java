package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a
 * href=https://leetcode.com/problems/number-of-restricted-paths-from-first-to-last-node>https://leetcode.com/problems/number-of-restricted-paths-from-first-to-last-node/</a>
 *
 * <p>Runtime: O(e * log(n)) (Dijkstra) + O(n) (DFS with DP) = O(e * log(n)) since graph is
 * connected (e >= n - 1)
 *
 * <p>Extra memory: O(n + e) ({@code adjList}) + O(n) (Dijkstra priority queue/costs) + O(n) (DFS
 * stack) + O(n) (DP table) = O(e + n)
 *
 * <p>Key: Dijkstra's to get {@code distanceToLastNode(x)} function. Then DFS with DP to count paths
 * from first to last node.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1786NumberOfRestrictedPathsFromFirstToLastNode {

  private static final int MOD = (int) 1e9 + 7;

  public int countRestrictedPaths(int n, int[][] edges) {
    // create adj list with weights
    Map<Integer, List<List<Integer>>> adjList = new HashMap<>();
    for (int[] edge : edges) {
      adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(List.of(edge[1], edge[2]));
      adjList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(List.of(edge[0], edge[2]));
    }

    // dijkstra's to find distances to last node from every other node
    int[] costs = new int[n + 1];
    Arrays.fill(costs, Integer.MAX_VALUE);
    costs[n] = 0;

    PriorityQueue<Integer> priorityQueue =
        new PriorityQueue<>(Comparator.comparingInt(i -> costs[i]));
    priorityQueue.add(n);

    while (!priorityQueue.isEmpty()) {
      int node = priorityQueue.remove();

      for (List<Integer> adj : adjList.get(node)) {
        int adjNode = adj.get(0);
        int edgeCost = adj.get(1);

        int alternativeCost = costs[node] + edgeCost;

        if (alternativeCost < costs[adjNode]) {
          costs[adjNode] = alternativeCost;
          priorityQueue.add(adjNode);
        }
      }
    }

    // now have distanceToLastNode(x) (Dijkstra costs array)
    // run DFS with DP to count the number of restricted paths from node 1 to node n
    return dfs(1, n, adjList, costs, new HashMap<>());
  }

  private int dfs(
      int node,
      int n,
      Map<Integer, List<List<Integer>>> adjList,
      int[] distanceToLastNode,
      Map<Integer, Integer> dp) {
    if (node == n) {
      return 1;
    }
    if (dp.containsKey(node)) {
      return dp.get(node);
    }

    long count = 0;
    for (List<Integer> adj : adjList.get(node)) {
      int adjNode = adj.get(0);
      // test distanceToLastNode(zi) > distanceToLastNode(zi+1) (requirement to continue the path)
      if (distanceToLastNode[node] > distanceToLastNode[adjNode]) {
        count += dfs(adjNode, n, adjList, distanceToLastNode, dp);
      }
    }
    count %= MOD;
    // memoize
    dp.put(node, (int) count);
    return (int) count;
  }
}
