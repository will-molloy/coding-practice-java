package com.willmolloy.leetcode.problemset.algorithms.medium;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/all-paths-from-source-to-target>https://leetcode.com/problems/all-paths-from-source-to-target/</a>
 *
 * <p>Runtime: O(|n| + |e|)
 *
 * <p>Extra memory: O(|n|)
 *
 * <p>Key: Copy path when it branches out since it is creating new paths. Basically, when they want
 * all results like this you have no choice but to brute force.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
@SuppressFBWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
class P797AllPathsFromSourceToTarget {

  private int[][] adjList;
  private int n;
  private List<List<Integer>> result;

  public List<List<Integer>> allPathsSourceTarget(int[][] adjList) {
    this.adjList = adjList;
    n = adjList.length;
    result = new ArrayList<>();
    dfs(0, new ArrayList<>());
    return result;
  }

  private void dfs(int node, List<Integer> path) {
    path.add(node);

    if (node == n - 1) {
      result.add(path);
    }

    for (int adjNode : adjList[node]) {
      dfs(adjNode, new ArrayList<>(path));
    }
  }
}
