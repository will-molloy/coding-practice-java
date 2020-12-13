package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/max-number-of-k-sum-pairs>https://leetcode.com/problems/max-number-of-k-sum-pairs/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Hashmap; 2-sum.
 *
 * @see com.wilmol.leetcode.problemset.algorithms.easy.P1TwoSum
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1679MaxNumberOfKSumPairs {

  public int maxOperations(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.merge(num, 1, Integer::sum);
    }

    int count = 0;
    for (var e : map.entrySet()) {
      // x + y = k
      // y = k - x
      int x = e.getKey();
      int y = k - x;
      if (map.containsKey(y)) {
        count += Math.min(e.getValue(), map.get(y));
      }
    }
    // want number of pairs, we looked up each num (each side of a pair) so divide by 2
    return count / 2;
  }
}
