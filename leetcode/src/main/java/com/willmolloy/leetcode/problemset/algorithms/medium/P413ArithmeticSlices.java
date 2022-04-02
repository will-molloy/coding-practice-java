package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Arrays;

/**
 * <a
 * href=https://leetcode.com/problems/arithmetic-slices>https://leetcode.com/problems/arithmetic-slices/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: dynamic programming. dp[i] represents the number of arithmetic subarrays ending at a[i].
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P413ArithmeticSlices {

  public int numberOfArithmeticSlices(int[] a) {
    int n = a.length;

    // dp[i] represents the number of arithmetic subarrays ending at a[i]
    int[] dp = new int[n];
    for (int i = 2; i < n; i++) {
      if (a[i] - a[i - 1] == a[i - 1] - a[i - 2]) {
        // extend all prior arithmetic subarrays and create a new one consisting of 3 elements
        dp[i] = dp[i - 1] + 1;
      }
    }

    return Arrays.stream(dp).sum();
  }
}
