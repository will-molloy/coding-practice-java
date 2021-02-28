package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/shortest-path-in-binary-matrix>https://leetcode.com/problems/shortest-path-in-binary-matrix/</a>
 *
 * <p>Runtime: O(rows * cols)
 *
 * <p>Extra memory: O(rows * cols)
 *
 * <p>Key: BFS.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1091ShortestPathInBinaryMatrix {

  public int shortestPathBinaryMatrix(int[][] grid) {
    if (grid[0][0] == 1) {
      return -1;
    }

    Set<List<Integer>> seen = new HashSet<>();
    Queue<List<Integer>> queue = new ArrayDeque<>();
    queue.add(List.of(0, 0));

    int rows = grid.length;
    int cols = grid[0].length;
    int length = 1;

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        List<Integer> node = queue.remove();
        int row = node.get(0);
        int col = node.get(1);
        if (row == rows - 1 && col == cols - 1) {
          return length;
        }

        for (int rowDelta = -1; rowDelta <= 1; rowDelta++) {
          for (int colDelta = -1; colDelta <= 1; colDelta++) {
            if (rowDelta == 0 && colDelta == 0) {
              continue;
            }
            int newRow = row + rowDelta;
            int newCol = col + colDelta;
            if (newRow >= 0
                && newRow < rows
                && newCol >= 0
                && newCol < cols
                && grid[newRow][newCol] == 0
                && seen.add(List.of(newRow, newCol))) {
              queue.add(List.of(newRow, newCol));
            }
          }
        }
      }
      length++;
    }
    return -1;
  }
}
