package com.willmolloy.leetcode.problemset.algorithms.hard;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * <a
 * href=https://leetcode.com/problems/longest-increasing-path-in-a-matrix>https://leetcode.com/problems/longest-increasing-path-in-a-matrix/</a>
 *
 * <p>Runtime: O(rows * cols)
 *
 * <p>Extra memory: O(rows * cols)
 *
 * <p>Key idea: DFS from every cell (consider each cell as the source). Memoise the result for each
 * cell.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
@SuppressFBWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
class P329LongestIncreasingPathInAMatrix {

  private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private int[][] matrix;
  private int rows;
  private int cols;

  private int[][] dp;

  public int longestIncreasingPath(int[][] matrix) {
    this.matrix = matrix;
    this.rows = matrix.length;
    this.cols = matrix[0].length;
    this.dp = new int[rows][cols];

    // dfs from every cell (consider each cell as the source)
    int max = 0;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        max = Math.max(max, dfs(row, col));
      }
    }
    return max;
  }

  private int dfs(int row, int col) {
    if (dp[row][col] != 0) {
      // result already computed for cell (row, col)
      return dp[row][col];
    }

    int result = 1;
    for (int[] d : DIRECTIONS) {
      int newRow = row + d[0];
      int newCol = col + d[1];
      if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
        // out of bounds
        continue;
      }
      if (matrix[newRow][newCol] <= matrix[row][col]) {
        // not an increasing path
        continue;
      }
      result = Math.max(result, 1 + dfs(newRow, newCol));
    }

    dp[row][col] = result;
    return result;
  }
}
