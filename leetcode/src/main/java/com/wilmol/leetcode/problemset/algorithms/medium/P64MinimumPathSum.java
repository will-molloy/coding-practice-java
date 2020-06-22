package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2019-12-15.
 *
 * <p><a
 * href=https://leetcode.com/problems/minimum-path-sum>https://leetcode.com/problems/minimum-path-sum</a>
 *
 * <p>Key: dynamic programming TODO shortest path algorithm (graph) is faster?
 *
 * @see P62UniquePaths
 * @see P63UniquePaths2
 * @see P120Triangle
 * @see com.wilmol.leetcode.problemset.algorithms.hard.P174DungeonGame
 */
interface P64MinimumPathSum {

  int minPathSum(int[][] grid);

  /**
   * Recursive (top down), correct but TLE on leetcode.
   *
   * <p>Runtime: TODO O(2<sup>n + m</sup>) ??? Same as {@link P62UniquePaths.TopDownRecursive}
   *
   * <p>Space: TODO O(nm) ??? Same as {@link P62UniquePaths.TopDownRecursive}
   */
  class RecursiveTopDown implements P64MinimumPathSum {

    public int minPathSum(int[][] grid) {
      // assumed at least 1x1 grid else IOOB
      int m = grid[0].length; // numCols
      int n = grid.length; // numRows
      return minPathSum(grid, 0, 0, n, m, grid[0][0]);
    }

    int minPathSum(int[][] grid, int row, int col, int numRows, int numCols, int cost) {
      if (row == numRows - 1 && col == numCols - 1) {
        return cost; // at bottom right
      }

      // going down
      int down = Integer.MAX_VALUE;
      if (row < numRows - 1) {
        down = minPathSum(grid, row + 1, col, numRows, numCols, cost + grid[row + 1][col]);
      }

      // going right
      int right = Integer.MAX_VALUE;
      if (col < numCols - 1) {
        right = minPathSum(grid, row, col + 1, numRows, numCols, cost + grid[row][col + 1]);
      }

      // greedy, pick fastest route
      return Math.min(down, right);
    }
  }

  /**
   * DP (bottom up)
   *
   * <p>Runtime: O(nm)
   *
   * <p>Space: O(nm) TODO can do O(m)/O(n) space (decide based on what is smaller) because can
   * reduce to 1d array since only ever look one square down/right (i.e. overwrite rows/cols bottom
   * up)
   */
  class DpBottomUp implements P64MinimumPathSum {

    // e.g. grid:
    // [1,3,1]
    // [1,5,1]
    // [4,2,1]

    // final dp:
    // [7,6,3]
    // [8,7,2]
    // [7,3,1]

    public int minPathSum(int[][] grid) {
      // assumed at least 1x1 grid else IOOB
      int numCols = grid[0].length;
      int numRows = grid.length;

      // dp[row][col] represents min path sum to bottom right corner from that cell
      int[][] dp = new int[numRows][numCols];

      // base case is bottom right corner
      dp[numRows - 1][numCols - 1] = grid[numRows - 1][numCols - 1];

      // right border
      for (int row = numRows - 2; row >= 0; row--) {
        // can only move down
        int down = dp[row + 1][numCols - 1];
        dp[row][numCols - 1] = grid[row][numCols - 1] + down;
      }

      // bottom border
      for (int col = numCols - 2; col >= 0; col--) {
        // can only move right
        int right = dp[numRows - 1][col + 1];
        dp[numRows - 1][col] = grid[numRows - 1][col] + right;
      }

      // fill in from bottom right corner, cols/rows first doesnt matter
      for (int row = numRows - 2; row >= 0; row--) {
        for (int col = numCols - 2; col >= 0; col--) {
          int down = dp[row + 1][col];
          int right = dp[row][col + 1];
          dp[row][col] = grid[row][col] + Math.min(down, right);
        }
      }

      // return min path sum from top left corner
      return dp[0][0];
    }
  }
}
