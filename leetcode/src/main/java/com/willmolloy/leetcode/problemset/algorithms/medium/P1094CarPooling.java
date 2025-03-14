package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Map;
import java.util.TreeMap;

/**
 * <a href=https://leetcode.com/problems/car-pooling>https://leetcode.com/problems/car-pooling/</a>
 *
 * <p>Runtime: O(n * log(n))
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: Check if the actual capacity ever exceeds the given capacity. Done by storing
 * increases and decreases in load at each position, then sorting by position, and then computing a
 * cumulative sum.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1094CarPooling {

  public boolean carPooling(int[][] trips, int capacity) {
    // position -> load
    Map<Integer, Integer> map = new TreeMap<>();

    for (int[] trip : trips) {
      int load = trip[0];
      int start = trip[1];
      int end = trip[2];
      map.merge(start, load, Integer::sum);
      map.merge(end, -load, Integer::sum);
    }

    int cumulativeLoad = 0;
    for (int load : map.values()) {
      cumulativeLoad += load;
      if (cumulativeLoad > capacity) {
        return false;
      }
    }
    return true;
  }
}
