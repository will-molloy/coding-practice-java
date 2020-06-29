package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/uncrossed-lines>https://leetcode.com/problems/uncrossed-lines/</a>
 *
 * <p>Runtime: O(a * b)
 *
 * <p>Extra space: O(a * b)
 *
 * <p>Key: Dynamic programming; LCS problem.
 *
 * @see P1143LongestCommonSubsequence
 * @see com.wilmol.leetcode.problemset.algorithms.hard.P1458MaxDotProductOfTwoSubsequences
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1035UncrossedLines {

  public int maxUncrossedLines(int[] a, int[] b) {
    // longest common subsequence problem
    // if we can find the longest common subsequence, we can guarantee the lines won't cross
    // e.g. a = [1, 4, 2] and b = [1, 2, 4] then LCS = [1, 4] or [1, 2]

    // dp[i][j] = answer considering a[0, i) and b[0, j)
    // (done this way to avoid checking i > 0 and j > 0 in the loop)
    int[][] dp = new int[a.length + 1][b.length + 1];

    for (int i = 1; i <= a.length; i++) {
      for (int j = 1; j <= b.length; j++) {
        if (a[i - 1] == b[j - 1]) {
          // can extend LCS
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          // can't extend LCS, carry over previous best
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[a.length][b.length];
  }
}
