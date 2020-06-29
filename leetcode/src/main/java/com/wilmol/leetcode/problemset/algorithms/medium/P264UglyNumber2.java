package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.stream.IntStream;

/**
 * <a
 * href=https://leetcode.com/problems/ugly-number-ii>https://leetcode.com/problems/ugly-number-ii</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key: faster to generate the numbers rather than test
 *
 * @see com.wilmol.leetcode.problemset.algorithms.easy.P263UglyNumber
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P264UglyNumber2 {

  public int nthUglyNumber(int n) {
    // testing isUgly is too slow, need to build up the numbers

    int[] dp = new int[n];
    // first ugly number is 1
    dp[0] = 1;

    // pointers for multiples of [2, 3, 5]
    int i2 = 0;
    int i3 = 0;
    int i5 = 0;

    for (int i = 1; i < n; i++) {
      // next number is min(2 * current2, 3 * current3, 5 * current5) (current multiple)
      // i.e.
      // min(2 * 1, 3 * 1, 5 * 1) = 2
      // min(2 * 2, 3 * 1, 5 * 1) = 3
      // min(2 * 2, 3 * 2, 5 * 1) = 4
      // min(2 * 3, 3 * 2, 5 * 1) = 5
      // min(2 * 3, 3 * 2, 5 * 2) = 6
      // min(2 * 4, 3 * 3, 5 * 2) = 8
      int ugly2 = 2 * dp[i2];
      int ugly3 = 3 * dp[i3];
      int ugly5 = 5 * dp[i5];
      dp[i] = min(ugly2, ugly3, ugly5);
      if (dp[i] == ugly2) {
        i2++;
      }
      if (dp[i] == ugly3) {
        i3++;
      }
      if (dp[i] == ugly5) {
        i5++;
      }
    }
    return dp[n - 1];
  }

  private int min(int... ints) {
    return IntStream.of(ints).min().getAsInt();
  }
}
