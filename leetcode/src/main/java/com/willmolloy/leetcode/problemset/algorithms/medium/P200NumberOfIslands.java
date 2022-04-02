package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/number-of-islands>https://leetcode.com/problems/number-of-islands</a>
 *
 * <p>Runtime: O(rows * cols) (yes we do more computation when there are '1's in the grid - but that
 * is proportional to rows * cols - i.e. worst case is O(2 * rows * cols), which is O(rows * cols))
 *
 * <p>Space: O(rows * cols) (worst case recursion stack size - whole grid is '1's)
 *
 * <p>Key: matrix traversal
 *
 * @see P130SurroundedRegions
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P463IslandPerimeter
 * @see P695MaxAreaOfIsland
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P733FloodFill
 * @see P1568MinimumNumberOfDaysToDisconnectIsland
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P200NumberOfIslands {

  // precondition:
  // grid[i].length is the same for all i = [0..grid.length)

  public int numIslands(char[][] grid) {
    int count = 0;
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        if (grid[row][col] == '1') {
          count += 1;
          clearIsland(grid, row, col);
        }
      }
    }
    return count;
  }

  private void clearIsland(char[][] grid, int row, int col) {
    if (row >= 0
        && row < grid.length
        && col >= 0
        && col < grid[0].length
        && grid[row][col] == '1') {
      grid[row][col] = '0';
      clearIsland(grid, row + 1, col);
      clearIsland(grid, row - 1, col);
      clearIsland(grid, row, col + 1);
      clearIsland(grid, row, col - 1);
    }
  }
}
