package com.willmolloy.leetcode.problemset.algorithms.hard;

/**
 * <a
 * href=https://leetcode.com/problems/cherry-pickup-ii>https://leetcode.com/problems/cherry-pickup-ii/</a>
 *
 * <p>Runtime: O(rows * cols<sup>2</sup>)
 *
 * <p>Extra memory: O(rows * cols<sup>2</sup>)
 *
 * <p>Key: Let {@code dp[row][col1][col2]} represent the maximum number of cherries if robot 1
 * starts at (row, col1) and robot 2 starts at (row, col2).
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1463CherryPickup2 {

  public int cherryPickup(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;

    // dp[row][col1][col2] = result for robot 1 starting at (row, col1) and robot 2 starting at
    // (row, col2)
    int[][][] dp = new int[rows][cols][cols];

    // bottom up dp
    for (int row = rows - 1; row >= 0; row--) {
      for (int col1 = 0; col1 < cols; col1++) {
        for (int col2 = 0; col2 < cols; col2++) {
          // pickup cherries from current cell(s) (base case also, where robots start in bottom row)
          if (col1 != col2) {
            dp[row][col1][col2] = grid[row][col1] + grid[row][col2];
          } else {
            // robots on same cell, don't double count
            dp[row][col1][col2] = grid[row][col1];
          }

          if (row == rows - 1) {
            // base case, robots in bottom row
            continue;
          }

          // recursive case, take the max path down
          int maxNext = 0;
          for (int col1Next = col1 - 1; col1Next <= col1 + 1; col1Next++) {
            for (int col2Next = col2 - 1; col2Next <= col2 + 1; col2Next++) {
              if (col1Next < 0 || col1Next >= cols || col2Next < 0 || col2Next >= cols) {
                // out of bounds
                continue;
              }
              maxNext = Math.max(maxNext, dp[row + 1][col1Next][col2Next]);
            }
          }
          dp[row][col1][col2] += maxNext;
        }
      }
    }
    // start with robot 1 in top left, robot 2 in top right
    return dp[0][0][cols - 1];
  }
}
