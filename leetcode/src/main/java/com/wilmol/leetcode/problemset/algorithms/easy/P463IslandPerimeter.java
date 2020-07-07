package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/island-perimeter>https://leetcode.com/problems/island-perimeter/</a>
 *
 * <p>Runtime: O(rows * cols)
 *
 * <p>Extra space: O(rows * cols)
 *
 * <p>Key: Setting {@code grid[row][col] = 2} so mark it as seen without marking it as water.
 *
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P200NumberOfIslands
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P695MaxAreaOfIsland
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P463IslandPerimeter {

  private int sum;

  public int islandPerimeter(int[][] grid) {
    sum = 0;
    // find island
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        if (grid[row][col] == 1) {
          dfs(grid, row, col);
          break;
        }
      }
    }
    return sum;
  }

  // for each island cell, count surrounding water cells, this is the perimeter
  private void dfs(int[][] grid, int row, int col) {
    if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
      if (grid[row][col] == 1) {
        // unseen island
        // mark seen with something other than island/water
        grid[row][col] = 2;
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
      } else if (grid[row][col] == 0) {
        // water
        sum++;
      }
    } else {
      // out of bounds (water)
      sum++;
    }
  }
}
