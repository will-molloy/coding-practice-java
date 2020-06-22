package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wilmol on 2019-11-03.
 *
 * <p><a
 * href=https://leetcode.com/problems/spiral-matrix>https://leetcode.com/problems/spiral-matrix/</a>
 *
 * <p>Runtime: O(n*m), process each element once.
 *
 * <p>Key: breaking the problem down with recursion; i.e. mxn matrix -> (m-2)x(n-2) matrix.
 *
 * <p>Then can simply apply the offset value (depth) consistently to the loop variable and lengths.
 *
 * <p>Also making the loop variable start at 0 consistently helped; i.e. can add or subtract it to
 * the other values as needed whether ascending or descending order rather than changing the logic
 * each time (this kept it much simpler).
 *
 * <p>The logic is basically the same as that used in {@link P48RotateImage}.
 *
 * @see P48RotateImage
 * @see P59SpiralMatrix2
 */
class P54SpiralMatrix {

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> order = new ArrayList<>();
    if (matrix.length > 0) {
      orderAtDepth(matrix, 0, order);
    }
    return order;
  }

  private void orderAtDepth(int[][] matrix, int depth, List<Integer> order) {
    // update lengths
    int numRows = matrix.length - depth * 2;
    int numCols = matrix[0].length - depth * 2;

    if (numRows < 1 || numCols < 1) {
      // base case, no more elements to add
      return;
    }

    if (numRows == 1) {
      // base case, single row
      for (int col = 0; col < numCols; col++) {
        // always offset with depth, only col is changing, row fixed at first/final row
        order.add(matrix[depth][depth + col]);
      }
      return;
    }

    if (numCols == 1) {
      // base case, single column
      for (int row = 0; row < numRows; row++) {
        // always offset with depth, only row is changing, col fixed at first/final column
        order.add(matrix[depth + row][depth]);
      }
      return;
    }

    // recursive case, add the 4 sides from this depth in the correct order
    // e.g. depth = 0 with 3x3 matrix:
    // 1,2,3
    // 4,5,6
    // 7,8,9
    // top = 1,2; right = 3,6; bottom = 9,8; left = 7,4

    // top
    for (int col = 0; col < numCols - 1; col++) {
      // always offset with depth, only col is changing, row fixed at first row
      order.add(matrix[depth][depth + col]);
    }

    // right
    for (int row = 0; row < numRows - 1; row++) {
      // always offset with depth, only row is changing, col fixed at final column
      order.add(matrix[depth + row][depth + numCols - 1]);
    }

    // bottom
    for (int col = 0; col < numCols - 1; col++) {
      // always offset with depth, only col is changing (in reverse), row fixed at final row
      order.add(matrix[depth + numRows - 1][depth + numCols - 1 - col]);
    }

    // left
    for (int row = 0; row < numRows - 1; row++) {
      // always offset with depth, only row is changing (in reverse), col fixed at first column
      order.add(matrix[depth + numRows - 1 - row][depth]);
    }

    orderAtDepth(matrix, depth + 1, order);
  }
}
