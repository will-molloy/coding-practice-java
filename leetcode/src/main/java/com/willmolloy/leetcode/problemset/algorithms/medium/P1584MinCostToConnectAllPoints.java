package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/min-cost-to-connect-all-points>https://leetcode.com/problems/min-cost-to-connect-all-points/</a>
 *
 * <p>Runtime: O(n<sup>2</sup>*log(n)) TODO can do O(n<sup>2</sup>) (no heap)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: MST. Prims is better than Kruskals for dense graphs (here the graph is complete
 * (worst case scenario), Kruskal has to sort n<sup>2</sup> edges which gets TLE).
 *
 * @see
 *     com.willmolloy.leetcode.problemset.algorithms.hard.P1579RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1584MinCostToConnectAllPoints {

  public int minCostConnectPoints(int[][] points) {
    int n = points.length;

    // prims MST algorithm

    // init
    int[] key = new int[n];
    for (int node = 0; node < n; node++) {
      key[node] = Integer.MAX_VALUE;
    }
    key[0] = 0;

    PriorityQueue<Integer> pQueue = new PriorityQueue<>(Comparator.comparingInt(node -> key[node]));
    for (int node = 0; node < n; node++) {
      pQueue.add(node);
    }

    int mstCost = 0;
    Set<Integer> inMst = new HashSet<>();

    // build MST
    while (!pQueue.isEmpty()) {
      int node = pQueue.remove();
      mstCost += key[node];
      inMst.add(node);

      if (pQueue.isEmpty()) {
        break;
      }

      for (int adjNode = 0; adjNode < n; adjNode++) {
        if (inMst.contains(adjNode)) {
          continue;
        }
        int cost =
            Math.abs(points[node][0] - points[adjNode][0])
                + Math.abs(points[node][1] - points[adjNode][1]);
        if (cost < key[adjNode]) {
          key[adjNode] = cost;
          // reheapify
          pQueue.remove(adjNode);
          pQueue.add(adjNode);
        }
      }
    }
    return mstCost;
  }
}
