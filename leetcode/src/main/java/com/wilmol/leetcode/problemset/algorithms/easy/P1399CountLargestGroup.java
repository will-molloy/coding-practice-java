package com.wilmol.leetcode.problemset.algorithms.easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/count-largest-group>https://leetcode.com/problems/count-largest-group/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(n)
 *
 * <p>Key: Group nums by their digit sums.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1399CountLargestGroup {

  public int countLargestGroup(int n) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      int digitSum = 0;
      int num = i;
      while (num > 0) {
        digitSum += num % 10;
        num /= 10;
      }
      map.merge(digitSum, 1, Integer::sum);
    }

    int maxGroupSize = 0;
    for (int groupSize : map.values()) {
      maxGroupSize = Math.max(maxGroupSize, groupSize);
    }

    return Collections.frequency(map.values(), maxGroupSize);
  }
}
