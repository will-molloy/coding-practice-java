package com.willmolloy.leetcode.problemset.algorithms.hard;

/**
 * <a
 * href=https://leetcode.com/problems/max-dot-product-of-two-subsequences>https://leetcode.com/problems/max-dot-product-of-two-subsequences/</a>
 *
 * <p>Runtime: O(n1 * n2)
 *
 * <p>Extra space: O(n1 * n2)
 *
 * <p>Key idea: Dynamic programming. Very similar to LCS problem.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P1035UncrossedLines
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P1143LongestCommonSubsequence
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1458MaxDotProductOfTwoSubsequences {

  public int maxDotProduct(int[] nums1, int[] nums2) {
    int n1 = nums1.length;
    int n2 = nums2.length;

    // longest common subsequence problem
    // (with a tricky tweak that the LCS must be non-empty)
    // we want to line up as many 'good' pairs as possible to create the largest sum
    // a pair is considered good if it increases the sum (i.e. pair two negatives or two positives)

    // dp[i][j] = answer considering nums1[0, i] and nums2[0, j]
    int[][] dp = new int[n1][n2];

    for (int i = 0; i < n1; i++) {
      for (int j = 0; j < n2; j++) {

        // subsequences must be non-empty so must store some product
        dp[i][j] = nums1[i] * nums2[j];

        if (i > 0 && j > 0) {
          // try extend the subsequences
          // i.e. if previous answer was non-negative include it, otherwise start fresh
          dp[i][j] += Math.max(0, dp[i - 1][j - 1]);
        }
        if (i > 0) {
          // check if not extending the subsequences is better
          // i.e. if previous subsequence (for n1) is better
          dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
        }
        if (j > 0) {
          // check if not extending the subsequences is better
          // i.e. if previous subsequence (for n2) is better
          dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
        }
      }
    }

    return dp[n1 - 1][n2 - 1];
  }
}
