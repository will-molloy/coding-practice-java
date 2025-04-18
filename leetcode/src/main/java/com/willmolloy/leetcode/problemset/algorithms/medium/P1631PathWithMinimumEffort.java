package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/path-with-minimum-effort>https://leetcode.com/problems/path-with-minimum-effort/</a>
 *
 * <p>Runtime: O(log(10<sup>6</sup>) * rows * cols)
 *
 * <p>Extra memory: O(rows * cols)
 *
 * <p>Key idea: Binary search the minimum effort. Test the effort using BFS or similar.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1631PathWithMinimumEffort {

  public int minimumEffortPath(int[][] heights) {
    int left = 0;
    int right = 1_000_000;
    int best = -1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (bfs(heights, mid)) {
        best = mid;
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return best;
  }

  // O(rows * cols)
  private boolean bfs(int[][] grid, int limit) {
    int rows = grid.length;
    int cols = grid[0].length;

    Queue<List<Integer>> queue = new ArrayDeque<>();
    queue.add(List.of(0, 0));
    Set<List<Integer>> seen = new HashSet<>();
    seen.add(List.of(0, 0));

    while (!queue.isEmpty()) {
      List<Integer> node = queue.remove();
      int row = node.get(0);
      int col = node.get(1);
      if (row == rows - 1 && col == cols - 1) {
        return true;
      }

      // up
      if (row > 0
          && Math.abs(grid[row][col] - grid[row - 1][col]) <= limit
          && seen.add(List.of(row - 1, col))) {
        queue.add(List.of(row - 1, col));
      }

      // down
      if (row < rows - 1
          && Math.abs(grid[row][col] - grid[row + 1][col]) <= limit
          && seen.add(List.of(row + 1, col))) {
        queue.add(List.of(row + 1, col));
      }

      // left
      if (col > 0
          && Math.abs(grid[row][col] - grid[row][col - 1]) <= limit
          && seen.add(List.of(row, col - 1))) {
        queue.add(List.of(row, col - 1));
      }

      // right
      if (col < cols - 1
          && Math.abs(grid[row][col] - grid[row][col + 1]) <= limit
          && seen.add(List.of(row, col + 1))) {
        queue.add(List.of(row, col + 1));
      }
    }
    return false;
  }
}
