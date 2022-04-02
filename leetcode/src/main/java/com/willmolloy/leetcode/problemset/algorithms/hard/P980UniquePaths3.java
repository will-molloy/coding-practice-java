package com.willmolloy.leetcode.problemset.algorithms.hard;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * <a
 * href=https://leetcode.com/problems/unique-paths-iii>https://leetcode.com/problems/unique-paths-iii/</a>
 *
 * <p>Runtime: O(3<sup>(rows * cols)</sup>) - branching factor is 3 because while we have 4
 * directions to explore, we don't count the one where we came from since it will terminate
 * immediately, except for the starting position - so it is O(4 * 3<sup>(rows * cols - 1)</sup>) =
 * O(3<sup>(rows * cols)</sup>)
 *
 * <p>Extra memory: O(rows * cols)
 *
 * <p>Key: Try all paths with recursion (DFS backtracking). Helps to first count non obstacle
 * squares (those with zeros) so know if the path is correct (visit each non obstacle exactly once)
 * when finding the end.
 *
 * @see P37SudokuSolver
 * @see P51NQueens
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P62UniquePaths
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P63UniquePaths2
 * @see P212WordSearch2
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
@SuppressFBWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
class P980UniquePaths3 {

  private int[][] grid;
  private int rows;
  private int cols;
  private int pathCount;
  private int countNonObstacleSquares;

  // CHECKSTYLE IGNORE AbbreviationAsWordInName FOR NEXT 1 LINES
  public int uniquePathsIII(int[][] grid) {
    this.grid = grid;
    rows = grid.length;
    cols = grid[0].length;
    pathCount = 0;

    countNonObstacleSquares = 0;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (grid[row][col] == 0) {
          countNonObstacleSquares++;
        }
      }
    }

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (grid[row][col] == 1) {
          // mark start as 0 so it continues the recursive DFS calls
          grid[row][col] = 0;
          // same with path length, need to offset by 1 since we're now counting the start
          dfs(row, col, -1);
          return pathCount;
        }
      }
    }
    throw new IllegalArgumentException("No start square");
  }

  private void dfs(int row, int col, int pathLength) {
    if (row >= 0 && row < rows && col >= 0 && col < cols) {
      if (pathLength == countNonObstacleSquares) {
        if (grid[row][col] == 2) {
          pathCount++;
        }
        return;
      }
      if (grid[row][col] == 0) {
        grid[row][col] = -1;
        dfs(row + 1, col, pathLength + 1);
        dfs(row - 1, col, pathLength + 1);
        dfs(row, col + 1, pathLength + 1);
        dfs(row, col - 1, pathLength + 1);
        grid[row][col] = 0;
      }
    }
  }
}
