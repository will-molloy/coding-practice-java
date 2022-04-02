package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/find-center-of-star-graph>https://leetcode.com/problems/find-center-of-star-graph/</a>
 *
 * <p>Runtime: O(1) - exactly 2 iterations over edges
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: All edges point to the center node, i.e. the center node is common/duplicate across all
 * edges.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1791FindCenterOfStarGraph {

  public int findCenter(int[][] edges) {
    Set<Integer> set = new HashSet<>();
    for (int[] edge : edges) {
      for (int node : edge) {
        if (!set.add(node)) {
          return node;
        }
      }
    }
    throw new AssertionError("Unreachable");
  }
}
