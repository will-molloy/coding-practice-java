package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a href=https://leetcode.com/problems/unique-paths>https://leetcode.com/problems/unique-paths</a>
 *
 * <p>Key idea: dynamic programming
 *
 * @see P63UniquePaths2
 * @see P64MinimumPathSum
 * @see P120Triangle
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P174DungeonGame
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P980UniquePaths3
 * @see P1594MaximumNonNegativeProductInAMatrix
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface P62UniquePaths {

  int uniquePaths(int m, int n);

  /**
   * Top down recursive solution. TLE on leetcode.
   *
   * <p>Runtime: O(2<sup>m + n</sup>), Space: O(m + n)
   */
  class TopDownRecursive implements P62UniquePaths {

    // m = num cols, n = num rows (doesn't actually matter, as long as kept consistent)
    public int uniquePaths(int m, int n) {
      return uniquePaths(m, n, 1, 1);
    }

    private int uniquePaths(int m, int n, int row, int col) {
      // base case
      if (row == n || col == m) {
        // on edges, can only move one direction (or already at finish), so only one path
        return 1;
      }
      // recursive case
      int down = uniquePaths(m, n, row + 1, col);
      int right = uniquePaths(m, n, row, col + 1);
      return down + right;
    }
  }

  /**
   * Bottom up dp solution. Passes leetcode.
   *
   * <p>Runtime: O(m*n), Space: O(m*n) TODO think can be done with 1d array (O(m) space) since only
   * ever look one space down/right
   */
  class BottomUpDp implements P62UniquePaths {

    // m = num cols, n = num rows (doesn't actually matter, as long as kept consistent)
    public int uniquePaths(int m, int n) {
      // dp[row][col] = num paths to finish from that position
      int[][] dp = new int[n][m];

      // base cases
      // bottom border, can only move one direction (i.e. right), so only one path
      for (int col = 0; col < m; col++) {
        dp[n - 1][col] = 1;
      }
      // right border, can only move one direction (i.e. down), so only one path
      for (int row = 0; row < n; row++) {
        dp[row][m - 1] = 1;
      }

      // recursive case, fill in bottom up
      for (int row = n - 2; row >= 0; row--) {
        for (int col = m - 2; col >= 0; col--) {
          int down = dp[row + 1][col];
          int right = dp[row][col + 1];
          dp[row][col] = down + right;
        }
      }

      // return num paths from start
      return dp[0][0];
    }
  }
}
