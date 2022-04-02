package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.StringJoiner;

/**
 * <a
 * href=https://leetcode.com/problems/path-with-maximum-probability>https://leetcode.com/problems/path-with-maximum-probability/</a>
 *
 * <p>Runtime: O(n + {@code edges}) (BFS cost)
 *
 * <p>Extra memory: O(n + {@code edges}) ({@code adjList} cost)
 *
 * <p>Key: Normal DFS/BFS doesn't work (gets TLE), instead need dynamic programming such that the
 * search only continues if the current path can result in a better result (a kind of pruning).
 * (Actually, DFS still times out with this dp table, the backtracking prunes too late.)
 *
 * <p>Shortest path algorithm also works (greedy, Dijkstra's), find path with min inverse of
 * probabilities (just pain to code due to fp arithmetic).
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1514PathWithMaximumProbability {

  public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
    Map<Integer, Set<NodeAndCost>> adjList = buildGraph(edges, succProb);

    // dp[i] = answer from start to node i
    double[] dp = new double[n];

    // BFS
    Queue<NodeAndCost> queue = new ArrayDeque<>();
    queue.add(new NodeAndCost(start, 1));
    while (!queue.isEmpty()) {
      NodeAndCost nodeAndCost = queue.remove();
      int node = nodeAndCost.node;
      double cost = nodeAndCost.cost;
      for (NodeAndCost adj : adjList.getOrDefault(node, Collections.emptySet())) {
        double newCost = cost * adj.cost;
        // only continue this path if it can result in a larger prob
        // this acts as a 'seen' array too (would never reuse an edge as it would lower the prob)
        if (newCost > dp[adj.node]) {
          queue.add(new NodeAndCost(adj.node, newCost));
          dp[adj.node] = newCost;
        }
      }
    }
    return dp[end];
  }

  private Map<Integer, Set<NodeAndCost>> buildGraph(int[][] edges, double[] succProb) {
    Map<Integer, Set<NodeAndCost>> adjList = new HashMap<>();
    for (int i = 0; i < edges.length; i++) {
      // undirected
      adjList
          .computeIfAbsent(edges[i][0], k -> new HashSet<>())
          .add(new NodeAndCost(edges[i][1], succProb[i]));
      adjList
          .computeIfAbsent(edges[i][1], k -> new HashSet<>())
          .add(new NodeAndCost(edges[i][0], succProb[i]));
    }
    return Collections.unmodifiableMap(adjList);
  }

  private static final class NodeAndCost {
    private final int node;
    private final double cost;

    NodeAndCost(int node, double cost) {
      this.node = node;
      this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      NodeAndCost nodeAndCost = (NodeAndCost) o;
      return node == nodeAndCost.node && Double.compare(nodeAndCost.cost, cost) == 0;
    }

    @Override
    public int hashCode() {
      return Objects.hash(node, cost);
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", NodeAndCost.class.getSimpleName() + "[", "]")
          .add("to=" + node)
          .add("prob=" + cost)
          .toString();
    }
  }
}
