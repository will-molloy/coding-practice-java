package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/lucky-numbers-in-a-matrix>https://leetcode.com/problems/lucky-numbers-in-a-matrix/</a>
 *
 * <p>Runtime: O(rows * cols)
 *
 * <p>Extra memory: O(rows * cols)
 *
 * <p>Key idea: Precompute both row minimums and column maximums. Then scan matrix again to find
 * elements in both sets.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1380LuckyNumbersInAMatrix {

  public List<Integer> luckyNumbers(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;

    boolean[][] rowMin = new boolean[rows][cols];
    for (int row = 0; row < rows; row++) {
      int min = 0;
      for (int col = 0; col < cols; col++) {
        if (matrix[row][col] < matrix[row][min]) {
          min = col;
        }
      }
      rowMin[row][min] = true;
    }

    boolean[][] colMax = new boolean[rows][cols];
    for (int col = 0; col < cols; col++) {
      int max = 0;
      for (int row = 0; row < rows; row++) {
        if (matrix[row][col] > matrix[max][col]) {
          max = row;
        }
      }
      colMax[max][col] = true;
    }

    List<Integer> result = new ArrayList<>();
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (rowMin[row][col] && colMax[row][col]) {
          result.add(matrix[row][col]);
        }
      }
    }
    return result;
  }
}
