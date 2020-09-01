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
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
@SuppressFBWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
class P952LargestComponentSizeByCommonFactor {

  private int[] parents;

  public int largestComponentSize(int[] nums) {
    // node values are in the range [1, 100000]
    // using root '0' for nodes not yet in the disjoint set
    parents = new int[100000 + 1];

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
    // TODO rank heuristic
    parents[find(nodeA)] = find(nodeB);
  }

  private int find(int node) {
    if (parents[node] == 0) {
      // make set
      parents[node] = node;
    } else if (node != parents[node]) {
      // path compression
      // TODO one pass path compression
      parents[node] = find(parents[node]);
    }
    return parents[node];
  }
}
