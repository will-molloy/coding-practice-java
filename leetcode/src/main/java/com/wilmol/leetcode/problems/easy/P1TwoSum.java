package com.wilmol.leetcode.problems.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Will on 2019-06-23 at 20:34.
 *
 * <p><a href=https://leetcode.com/problems/two-sum>https://leetcode.com/problems/two-sum</a>
 *
 * <p>Runtime: O(n) - single pass on ints, but O(n) memory too
 */
class P1TwoSum {

  private static final int[] EMPTY = new int[] {};

  int[] solve(int[] ints, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < ints.length; i++) {
      if (map.containsKey(ints[i])) {
        return new int[] {map.get(ints[i]), i};
      }
      map.put(target - ints[i], i);
    }
    return EMPTY;
  }
}
