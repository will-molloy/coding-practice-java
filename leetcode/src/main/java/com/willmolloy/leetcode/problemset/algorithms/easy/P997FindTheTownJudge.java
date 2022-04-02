package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/find-the-town-judge>https://leetcode.com/problems/find-the-town-judge/</a>
 *
 * <p>Runtime: O(n + t)
 *
 * <p>Extra space: O(n)
 *
 * <p>Key: Node degree.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P997FindTheTownJudge {

  public int findJudge(int n, int[][] trusts) {
    // problem can be modelled by a directed graph

    // these can be arrays (since nodes are in the range [1, n])
    // actually, can use a single array, add 1 for incoming edge, subtract 1 for outgoing edge
    // (some kind of node degree 'balance')
    Map<Integer, Integer> outDegree = new HashMap<>();
    Map<Integer, Integer> inDegree = new HashMap<>();

    for (int[] trust : trusts) {
      outDegree.merge(trust[0], 1, Integer::sum);
      inDegree.merge(trust[1], 1, Integer::sum);
    }

    for (int i = 1; i <= n; i++) {
      if (outDegree.getOrDefault(i, 0) == 0 && inDegree.getOrDefault(i, 0) == n - 1) {
        // only one node can satisfy the 2 properties, if n - 1 in-degree then n - 1 nodes would
        // need to have > 0 out-degree
        return i;
      }
    }
    return -1;
  }
}
