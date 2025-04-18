package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/longest-harmonious-subsequence>https://leetcode.com/problems/longest-harmonious-subsequence/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: Count frequencies. Answer is largest frequencies of some {@code num} and {@code num
 * + 1} - assuming they exist in the array.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P594LongestHarmoniousSubsequence {

  public int findLhs(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.merge(num, 1, Integer::sum);
    }

    int max = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int num = entry.getKey();
      if (map.containsKey(num + 1)) {
        max = Math.max(max, entry.getValue() + map.get(num + 1));
      }
    }
    return max;
  }
}
