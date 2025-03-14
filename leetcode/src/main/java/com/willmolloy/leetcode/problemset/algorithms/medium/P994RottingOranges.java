package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/rotting-oranges>https://leetcode.com/problems/rotting-oranges/</a>
 *
 * <p>Runtime: O(n<sup>2</sup>), where n = number of cells, worst case loop over grid n times, easy
 * to see with 1xk or kx1 example
 *
 * <p>Extra memory: O(n), where n = number of cells
 *
 * <p>Key idea: max n is 100, so can bruteforce the simulation; keep going until grid stops
 * changing.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P994RottingOranges {

  public int orangesRotting(int[][] grid) {
    boolean change = true;
    int minutes = 0;

    while (change) {
      change = false;
      int[][] copy = new int[grid.length][grid[0].length];

      for (int row = 0; row < grid.length; row++) {
        for (int col = 0; col < grid[0].length; col++) {

          if (grid[row][col] == 1
              && (row > 0 && grid[row - 1][col] == 2
                  || row < grid.length - 1 && grid[row + 1][col] == 2
                  || col > 0 && grid[row][col - 1] == 2
                  || col < grid[0].length - 1 && grid[row][col + 1] == 2)) {
            change = true;
            copy[row][col] = 2;
          } else {
            copy[row][col] = grid[row][col];
          }
        }
      }
      grid = copy;
      if (change) {
        minutes++;
      }
    }

    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        if (grid[row][col] == 1) {
          return -1;
        }
      }
    }
    return minutes;
  }
}
