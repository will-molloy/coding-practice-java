package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island>https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/</a>
 *
 * <p>Runtime: O((rows * cols)<sup>2</sup>)
 *
 * <p>Extra memory: O(rows * cols) (recursion stack space)
 *
 * <p>Key: Result is always <= 2, since can isolate any corner block with at most two removals.
 * Therefore only need to test case where result is 0 (test initially) and 1 (try remove each 1).
 *
 * @see P130SurroundedRegions
 * @see P200NumberOfIslands
 * @see com.wilmol.leetcode.problemset.algorithms.easy.P463IslandPerimeter
 * @see P695MaxAreaOfIsland
 * @see com.wilmol.leetcode.problemset.algorithms.easy.P733FloodFill
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1568MinimumNumberOfDaysToDisconnectIsland {

  public int minDays(int[][] grid) {
    if (numIslands(grid) != 1) {
      return 0;
    }

    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        if (grid[row][col] == 1) {
          grid[row][col] = 0;
          if (numIslands(grid) != 1) {
            return 1;
          }
          grid[row][col] = 1;
        }
      }
    }

    return 2;
  }

  // O(rows * cols)
  private int numIslands(int[][] grid) {
    int count = 0;

    // count islands
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        if (grid[row][col] == 1) {
          count++;
          dfsNumIslands(grid, row, col);
        }
      }
    }

    // restore islands
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        if (grid[row][col] == 2) {
          grid[row][col] = 1;
        }
      }
    }

    return count;
  }

  // clears an island so it isn't double counted
  private void dfsNumIslands(int[][] grid, int row, int col) {
    if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1) {
      // don't make 0, otherwise can't restore island
      grid[row][col] = 2;
      dfsNumIslands(grid, row + 1, col);
      dfsNumIslands(grid, row - 1, col);
      dfsNumIslands(grid, row, col + 1);
      dfsNumIslands(grid, row, col - 1);
    }
  }
}
