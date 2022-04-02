package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix>https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/</a>
 *
 * <p>Runtime: O(2<sup>(rows + cols)</sup>) TODO O(rows * cols) (bottom up DP) is possible
 *
 * <p>Extra memory: O(rows + cols) (DFS depth - remember can only move down or right)
 *
 * <p>Key: Try all the paths (DFS) with some pruning.
 *
 * @see P62UniquePaths
 * @see P64MinimumPathSum
 * @see P152MaximumProductSubarray
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1594MaximumNonNegativeProductInAMatrix {

  // constraints were small enough (rows/cols <= 15) that this was accepted in the contest

  private int rows;
  private int cols;
  private long max;

  public int maxProductPath(int[][] grid) {
    rows = grid.length;
    cols = grid[0].length;
    max = Integer.MIN_VALUE;

    dfs(0, 0, grid, grid[0][0]);

    if (max < 0) {
      return -1;
    } else {
      return (int) (max % (int) (1e9 + 7));
    }
  }

  void dfs(int row, int col, int[][] grid, long path) {
    // prune path = 0 (since it stays at 0), otherwise get TLE on LC
    if (row == rows - 1 && col == cols - 1 || path == 0) {
      max = Math.max(max, path);
      return;
    }

    // down
    if (row + 1 < rows) {
      dfs(row + 1, col, grid, path * grid[row + 1][col]);
    }
    // right
    if (col + 1 < cols) {
      dfs(row, col + 1, grid, path * grid[row][col + 1]);
    }
  }
}
