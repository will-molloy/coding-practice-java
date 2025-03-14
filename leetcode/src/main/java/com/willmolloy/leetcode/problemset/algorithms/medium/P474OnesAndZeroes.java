package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/ones-and-zeroes>https://leetcode.com/problems/ones-and-zeroes/</a>
 *
 * <p>Runtime: O(n * maxZeroes * maxOnes)
 *
 * <p>Extra memory: O(n * maxZeroes * maxOnes)
 *
 * <p>Key idea: Knapsack problem.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P474OnesAndZeroes {

  public int findMaxForm(String[] strs, int maxZeroes, int maxOnes) {
    int n = strs.length;

    // dp[i][zeroes][ones]:
    // answer considering: strs[0, i), maxZeroes = zeroes, maxOnes = ones
    int[][][] dp = new int[n + 1][maxZeroes + 1][maxOnes + 1];

    for (int i = 1; i < n + 1; i++) {
      int needOnes = 0;
      int needZeroes = 0;
      for (char c : strs[i - 1].toCharArray()) {
        switch (c) {
          case '0':
            needZeroes++;
            break;
          case '1':
            needOnes++;
            break;
          default:
        }
      }

      for (int zeroes = 0; zeroes < maxZeroes + 1; zeroes++) {
        for (int ones = 0; ones < maxOnes + 1; ones++) {
          if (zeroes >= needZeroes && ones >= needOnes) {
            // can take strs[i - 1]
            // recurrence relation: max(dont take, take)
            dp[i][zeroes][ones] =
                Math.max(
                    dp[i - 1][zeroes][ones], dp[i - 1][zeroes - needZeroes][ones - needOnes] + 1);
          } else {
            // can't take strs[i - 1]
            dp[i][zeroes][ones] = dp[i - 1][zeroes][ones];
          }
        }
      }
    }
    return dp[n][maxZeroes][maxOnes];
  }
}
