package com.wilmol.leetcode.problemset.algorithms.medium;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero>https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/</a>
 *
 * <p>Runtime: O(n) (only {@code dfs} onto nodes once, there are O(n) nodes and O(n) edges so
 * amortised cost is O(n) overall)
 *
 * <p>Extra space: O(n)
 *
 * <p>Key: Problem wording is confusing. Because it is a tree, there is only one path back to zero,
 * so simply need to count the edges pointing away from zero (i.e. min count = exact count).
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
@SuppressFBWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
class P1466ReorderRoutesToMakeAllPathsLeadToTheCityZero {

  private Map<Integer, Set<Integer>> adjList;
  private Set<Integer> seen;
  private int count;

  public int minReorder(int n, int[][] connections) {
    adjList = new HashMap<>();
    for (int[] edge : connections) {
      adjList.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
    }

    seen = new HashSet<>();

    // recursively count edges pointing AWAY from 0
    // doing this by counting nodes reachable from 0
    // (i.e. the edges pointing to those nodes should be reversed)
    // and then doing the same for source nodes unreachable from 0
    // (i.e. the edges pointing to the children of those source nodes should be reversed such that
    // the children can reach a node that can reach 0)
    // (actually, just trying each node as the source cause its easier to program)
    count = 0;
    for (int source = 0; source < n; source++) {
      if (seen.add(source)) {
        dfs(source);
      }
    }
    return count;
  }

  private void dfs(int node) {
    for (int adjNode : adjList.getOrDefault(node, Collections.emptySet())) {
      if (seen.add(adjNode)) {
        count++;
        dfs(adjNode);
      }
    }
  }
}
