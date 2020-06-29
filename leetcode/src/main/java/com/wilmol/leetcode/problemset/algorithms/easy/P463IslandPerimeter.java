package com.wilmol.leetcode.problemset.algorithms.easy;

import java.util.Arrays;

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

  // TODO there is a cleaner way using math, but was too lazy

  public int islandPerimeter(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (grid[row][col] == 1) {
          return dfs(grid, row, col, 0);
        }
      }
    }
    throw new IllegalArgumentException(Arrays.toString(grid));
  }

  private int dfs(int[][] grid, int row, int col, int perimeter) {
    // invariant: grid[row][col] == 1

    int rows = grid.length;
    int cols = grid[0].length;

    // mark cell as seen without marking it as water (otherwise incorrectly count extra)
    grid[row][col] = 2;

    // up
    if (row > 0 && grid[row - 1][col] == 1) {
      // island on this side
      perimeter = dfs(grid, row - 1, col, perimeter);
    } else if (row == 0 || grid[row - 1][col] == 0) {
      // water on this side
      perimeter++;
    }

    // down
    if (row < rows - 1 && grid[row + 1][col] == 1) {
      perimeter = dfs(grid, row + 1, col, perimeter);
    } else if (row == rows - 1 || grid[row + 1][col] == 0) {
      perimeter++;
    }

    // left
    if (col > 0 && grid[row][col - 1] == 1) {
      perimeter = dfs(grid, row, col - 1, perimeter);
    } else if (col == 0 || grid[row][col - 1] == 0) {
      perimeter++;
    }

    // right
    if (col < cols - 1 && grid[row][col + 1] == 1) {
      perimeter = dfs(grid, row, col + 1, perimeter);
    } else if (col == cols - 1 || grid[row][col + 1] == 0) {
      perimeter++;
    }

    return perimeter;
  }
}
