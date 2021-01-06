package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href=https://leetcode.com/problems/4sum-ii>https://leetcode.com/problems/4sum-ii/</a>
 *
 * <p>Runtime: O(n<sup>2</sup>)
 *
 * <p>Extra memory: O(n<sup>2</sup>)
 *
 * <p>Key: Compute {@code a + b} and {@code c + d} separately then look up (count) how many {@code a
 * + b = -(c + d)}.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P454FourSum2 {

  public int fourSumCount(int[] as, int[] bs, int[] cs, int[] ds) {
    Map<Integer, Integer> ab = new HashMap<>();
    for (int a : as) {
      for (int b : bs) {
        ab.merge(a + b, 1, Integer::sum);
      }
    }

    Map<Integer, Integer> cd = new HashMap<>();
    for (int c : cs) {
      for (int d : ds) {
        cd.merge(c + d, 1, Integer::sum);
      }
    }

    int count = 0;
    for (var abEntry : ab.entrySet()) {
      if (cd.containsKey(-abEntry.getKey())) {
        count += abEntry.getValue() * cd.get(-abEntry.getKey());
      }
    }
    return count;
  }
}
