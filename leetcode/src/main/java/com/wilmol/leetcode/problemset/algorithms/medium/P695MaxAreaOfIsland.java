package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/max-area-of-island>https://leetcode.com/problems/max-area-of-island/</a>
 *
 * <p>Runtime: O(rows * cols)
 *
 * <p>Extra space: O(rows * cols)
 *
 * <p>Key: care taken when passing around {@code area} parameter. Either use reference (e.g. int
 * array), or update based on recursive call results.
 *
 * @see P200NumberOfIslands
 * @see com.wilmol.leetcode.problemset.algorithms.easy.P463IslandPerimeter
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P695MaxAreaOfIsland {

  // if the input is immutable, can use boolean[][] seen array

  public int maxAreaOfIsland(int[][] grid) {
    int max = 0;
    int rows = grid.length;
    int cols = grid[0].length;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (grid[row][col] == 1) {
          max = Math.max(dfs(grid, row, col, 0), max);
        }
      }
    }
    return max;
  }

  private int dfs(int[][] grid, int row, int col, int area) {
    int rows = grid.length;
    int cols = grid[0].length;
    if ((row >= 0 && row < rows) && (col >= 0 && col < cols) && grid[row][col] == 1) {
      // count this cell
      area++;

      // mark this cell as seen
      grid[row][col] = 0;

      // search all 4 directions
      area = dfs(grid, row + 1, col, area);
      area = dfs(grid, row - 1, col, area);
      area = dfs(grid, row, col + 1, area);
      area = dfs(grid, row, col - 1, area);
    }
    return area;
  }
}
