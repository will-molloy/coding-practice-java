package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.List;

/**
 * Created by wilmol on 2020-02-23.
 *
 * <p><a href=https://leetcode.com/problems/triangle>https://leetcode.com/problems/triangle</a>
 *
 * <p>Runtime: O(n<sup>2</sup>)
 *
 * <p>Space: O(n) TODO can do O(1) if you use triangle as dp
 *
 * <p>Key: dynamic programming
 *
 * @see P62UniquePaths
 * @see P63UniquePaths2
 * @see P64MinimumPathSum
 * @see com.wilmol.leetcode.problemset.algorithms.hard.P174DungeonGame
 */
class P120Triangle {

  public int minimumTotal(List<List<Integer>> triangle) {
    // dp[row][col] represents min cost from (row, col) to bottom
    // base case:
    // - when in last row, cost to bottom is cost of cell
    // recursive case:
    // - dp[row][col] = min(dp[row+1][col], dp[row+1][col+1]) + cost of cell
    // since only depend on next row/col, can flatten dp to 1d array (if doing cols in ascending
    // order)
    int[] dp = new int[triangle.size() + 1];
    for (int row = triangle.size() - 1; row >= 0; row--) {
      for (int col = 0; col < triangle.get(row).size(); col++) {
        int cellCost = triangle.get(row).get(col);
        dp[col] = Math.min(dp[col], dp[col + 1]) + cellCost;
      }
    }
    return dp[0];
  }
}
