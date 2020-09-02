package com.wilmol.leetcode.problemset.algorithms.medium;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * <a
 * href=https://leetcode.com/problems/friend-circles>https://leetcode.com/problems/friend-circles/</a>
 *
 * <p>Runtime: O(n<sup>2</sup>)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Identify connected components. Used disjoint set (union find) here.
 *
 * @see com.wilmol.leetcode.problemset.algorithms.hard.P952LargestComponentSizeByCommonFactor
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
@SuppressFBWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
class P547FriendCircles {

  private int[] parent;

  private int[] rank;

  public int findCircleNum(int[][] m) {
    int n = m.length;

    // make n sets
    parent = IntStream.range(0, n).toArray();
    rank = new int[n];

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (m[i][j] == 1) {
          union(i, j);
        }
      }
    }

    Set<Integer> sets = new HashSet<>();
    for (int i = 0; i < n; i++) {
      sets.add(find(i));
    }
    return sets.size();
  }

  private void union(int i, int j) {
    int setI = find(i);
    int setJ = find(j);
    if (rank[setI] < rank[setJ]) {
      parent[setI] = setJ;
    } else {
      parent[setJ] = setI;
      if (rank[setI] == rank[setJ]) {
        rank[setI]++;
      }
    }
  }

  private int find(int i) {
    if (i != parent[i]) {
      parent[i] = find(parent[i]);
    }
    return parent[i];
  }
}
