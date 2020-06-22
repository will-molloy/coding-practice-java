package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Created by wilmol on 2020-06-14.
 *
 * <p><a
 * href=https://leetcode.com/problems/cheapest-flights-within-k-stops>https://leetcode.com/problems/cheapest-flights-within-k-stops/</a>
 */
interface P787CheapestFlightsWithinKStops {

  int findCheapestPrice(int n, int[][] flights, int src, int dst, int k);

  /**
   * Runtime: O(n + flights)
   *
   * <p>Extra space: O(n + flights)
   *
   * <p>Key: BFS with edge costs; track nodes with costs in the queue.
   */
  class Bfs implements P787CheapestFlightsWithinKStops {

    @Override
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
      // have to use adj list because leetcode makes stupid small memory limit
      Map<Integer, Set<int[]>> adjList = new LinkedHashMap<>();
      for (int node = 0; node < n; node++) {
        adjList.put(node, new LinkedHashSet<>());
      }
      for (int[] flight : flights) {
        adjList.get(flight[0]).add(new int[] {flight[1], flight[2]});
      }

      // min cost to dst
      int minCost = Integer.MAX_VALUE;

      // BFS up to level k (DFS gets TLE even though max n pretty small)
      Queue<int[]> queue = new ArrayDeque<>();
      queue.add(new int[] {src, 0});

      int level = -1;
      while (!queue.isEmpty() && level <= k) {
        level++;
        int levelSize = queue.size();

        for (int i = 0; i < levelSize; i++) {
          int[] node = queue.remove();
          if (node[0] == dst) {
            minCost = Math.min(minCost, node[1]);
          }

          for (int[] adjNode : adjList.get(node[0])) {
            // need this optimisation (ignore paths which would cost more than current answer)
            // otherwise leetcode gives TLE... but stupid cause complexity is same
            if (node[1] + adjNode[1] < minCost) {
              queue.add(new int[] {adjNode[0], node[1] + adjNode[1]});
            }
          }
        }
      }
      return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
  }

  /**
   * Runtime: O(n * log(n) + flights)
   *
   * <p>Extra space: O(n + flights)
   *
   * <p>Key: Dijkstra's algorithm. Store node with cost in queue. Also store path length because we
   * remove path with smallest cost not path will smallest length (so not guaranteed to traverse
   * level by level, so this is only way to know current level).
   */
  class Dijkstra implements P787CheapestFlightsWithinKStops {

    @Override
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
      // have to use adj list because leetcode makes stupid small memory limit
      Map<Integer, Set<int[]>> adjList = new LinkedHashMap<>();
      for (int node = 0; node < n; node++) {
        adjList.put(node, new LinkedHashSet<>());
      }
      for (int[] flight : flights) {
        adjList.get(flight[0]).add(new int[] {flight[1], flight[2]});
      }

      // dijkstra src to dst
      PriorityQueue<int[]> pQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
      // store {node, cost (from src), stops (from src)}
      pQueue.add(new int[] {src, 0, -1});

      while (!pQueue.isEmpty()) {
        int[] node = pQueue.remove();
        if (node[2] > k) {
          continue;
        }
        if (node[0] == dst) {
          return node[1];
        }

        for (int[] adjNode : adjList.get(node[0])) {
          pQueue.add(new int[] {adjNode[0], node[1] + adjNode[1], node[2] + 1});
        }
      }
      return -1;
    }
  }
}
