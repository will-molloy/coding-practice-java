package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/pacific-atlantic-water-flow>https://leetcode.com/problems/pacific-atlantic-water-flow/</a>
 *
 * <p>Runtime: O({@code rows} * {@code cols})
 *
 * <p>Extra memory: O({@code rows} * {@code cols})
 *
 * <p>Key: Rather than traverse (with either dfs or bfs) from each cell, work in reverse by
 * traversing from the borders (with the opposite rule - that the water level must increase in
 * height).
 *
 * <p>This reduces the time complexity from O(({@code rows} * {@code cols})<sup>2</sup>) to O({@code
 * rows} * {@code cols}).
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P417PacificAtlanticWaterFlow {

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    int rows = heights.length;
    int cols = heights[0].length;

    boolean[][] pacific = new boolean[rows][cols];
    boolean[][] atlantic = new boolean[rows][cols];

    // dfs from pacific
    // left border
    for (int row = 0; row < rows; row++) {
      dfs(row, 0, pacific, heights, Integer.MIN_VALUE);
    }
    // top border
    for (int col = 0; col < cols; col++) {
      dfs(0, col, pacific, heights, Integer.MIN_VALUE);
    }

    // dfs from atlantic
    // right border
    for (int row = 0; row < rows; row++) {
      dfs(row, cols - 1, atlantic, heights, Integer.MIN_VALUE);
    }
    // bottom border
    for (int col = 0; col < cols; col++) {
      dfs(rows - 1, col, atlantic, heights, Integer.MIN_VALUE);
    }

    // gather result
    List<List<Integer>> result = new ArrayList<>();
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (pacific[row][col] && atlantic[row][col]) {
          result.add(List.of(row, col));
        }
      }
    }
    return result;
  }

  private final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private void dfs(int row, int col, boolean[][] seen, int[][] heights, int prevHeight) {
    int rows = heights.length;
    int cols = heights[0].length;

    if (row < 0 || row >= rows || col < 0 || col >= cols) {
      // out of bounds
      return;
    }
    if (heights[row][col] < prevHeight) {
      // since we're traversing in from the ocean, the water level must increase (not decrease)
      return;
    }
    if (seen[row][col]) {
      // already seen
      return;
    }
    seen[row][col] = true;

    for (int[] d : directions) {
      dfs(row + d[0], col + d[1], seen, heights, heights[row][col]);
    }
  }
}
