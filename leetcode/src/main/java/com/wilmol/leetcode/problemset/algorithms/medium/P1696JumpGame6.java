package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.TreeMap;

/**
 * <a
 * href=https://leetcode.com/problems/jump-game-vi>https://leetcode.com/problems/jump-game-vi/</a>
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
interface P1696JumpGame6 {

  int maxResult(int[] nums, int k);

  /**
   * Naive dp.
   *
   * <p>Runtime: O(n * k)
   *
   * <p>Extra memory: O(n)
   *
   * <p>Key: Question pretty much gives the dp formula.
   */
  class NaiveDp implements P1696JumpGame6 {

    @Override
    public int maxResult(int[] nums, int k) {
      int n = nums.length;

      int[] dp = new int[n];

      for (int i = n - 1; i >= 0; i--) {
        dp[i] = nums[i];
        if (i == n - 1) {
          continue;
        }
        // find max sub path
        // min/2 to avoid overflows
        int max = Integer.MIN_VALUE / 2;
        for (int j = i + 1; j <= Math.min(n - 1, i + k); j++) {
          max = Math.max(max, dp[j]);
        }
        dp[i] += max;
      }
      return dp[0];
    }
  }

  /**
   * Accepted dp.
   *
   * <p>Runtime: O(n * log(k))
   *
   * <p>Extra memory: O(n)
   *
   * <p>Key: Instead of looking for max each time, remember it with heap.
   */
  class AcceptedDp implements P1696JumpGame6 {

    @Override
    public int maxResult(int[] nums, int k) {
      int n = nums.length;

      int[] dp = new int[n];

      // need TreeMap as multiset heap to efficiently find max in the jumping range
      TreeMap<Integer, Integer> multiset = new TreeMap<>();

      for (int i = n - 1; i >= 0; i--) {
        dp[i] = nums[i];
        if (i == n - 1) {
          continue;
        }
        // find max sub path
        // sliding window [i + 1, i + k]
        multiset.merge(dp[i + 1], 1, Integer::sum);
        if (i + k + 1 < n) {
          multiset.merge(dp[i + k + 1], -1, Integer::sum);
          if (multiset.get(dp[i + k + 1]) == 0) {
            multiset.remove(dp[i + k + 1]);
          }
        }
        dp[i] += multiset.lastKey();
      }
      return dp[0];
    }
  }
}
