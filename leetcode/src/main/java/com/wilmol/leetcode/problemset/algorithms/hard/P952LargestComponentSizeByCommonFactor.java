package com.wilmol.leetcode.problemset.algorithms.hard;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/largest-component-size-by-common-factor>https://leetcode.com/problems/largest-component-size-by-common-factor/</a>
 *
 * <p>Runtime: O(n*sqrt(max(nums)))
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Disjoint set.
 *
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P547FriendCircles
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
@SuppressFBWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
class P952LargestComponentSizeByCommonFactor {

  private int[] parent;

  private int[] rank;

  public int largestComponentSize(int[] nums) {
    // node values are in the range [1, 100000]
    // using root '0' for nodes not yet in the disjoint set
    parent = new int[100000 + 1];
    rank = new int[100000 + 1];

    // create disjoint set
    for (int num : nums) {
      // union each num with all its factors
      for (int factor = 2; factor * factor <= num; factor++) {
        if (num % factor == 0) {
          union(num, factor);
          union(num, num / factor);
        }
      }
    }

    // find largest set in the disjoint set
    Map<Integer, Integer> freq = new HashMap<>();
    for (int num : nums) {
      freq.put(find(num), freq.getOrDefault(find(num), 0) + 1);
    }
    return freq.values().stream().mapToInt(Integer::intValue).max().getAsInt();
  }

  private void union(int nodeA, int nodeB) {
    int setA = find(nodeA);
    int setB = find(nodeB);
    // rank heuristic:
    // make smaller tree subtree of larger tree
    // (here, rank is upper bound on height)
    if (rank[setA] < rank[setB]) {
      parent[setA] = setB;
    } else {
      parent[setB] = setA;
      if (rank[setA] == rank[setB]) {
        rank[setA]++;
      }
    }
  }

  private int find(int node) {
    if (parent[node] == 0) {
      // make set (lazy)
      parent[node] = node;
    } else if (node != parent[node]) {
      // path compression (two pass)
      parent[node] = find(parent[node]);
    }
    return parent[node];
  }
}
