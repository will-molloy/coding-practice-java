package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/maximal-network-rank>https://leetcode.com/problems/maximal-network-rank/</a>
 *
 * <p>Runtime: O({@code roads} + {@code n}<sup>2</sup>) = O({@code n}<sup>2</sup>)
 *
 * <p>Extra memory: O({@code n} + {@code roads})
 *
 * <p>Key: Combine node pair degrees. If pair is connected, only count the connecting edge once.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1615MaximalNetworkRank {

  public int maximalNetworkRank(int n, int[][] roads) {
    int[] degree = new int[n];
    Set<Set<Integer>> roadSet = new HashSet<>();
    for (int[] road : roads) {
      degree[road[0]]++;
      degree[road[1]]++;
      roadSet.add(Set.of(road[0], road[1]));
    }

    int max = 0;
    for (int a = 0; a < n; a++) {
      for (int b = a + 1; b < n; b++) {
        int roadDegree = degree[a] + degree[b];
        if (roadSet.contains(Set.of(a, b))) {
          // a <-> b, only count connecting edge once
          roadDegree--;
        }
        max = Math.max(max, roadDegree);
      }
    }
    return max;
  }
}
