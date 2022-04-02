package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/special-positions-in-a-binary-matrix>https://leetcode.com/problems/special-positions-in-a-binary-matrix/</a>
 *
 * <p>Runtime: O((rows*cols)*(rows + cols))
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Brute force, test every cell.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1582SpecialPositionsInABinaryMatrix {

  public int numSpecial(int[][] mat) {
    int count = 0;
    for (int row = 0; row < mat.length; row++) {
      for (int col = 0; col < mat[0].length; col++) {
        if (mat[row][col] == 1 && isOk(mat, row, col)) {
          count++;
        }
      }
    }
    return count;
  }

  private boolean isOk(int[][] mat, int row, int col) {
    for (int r = 0; r < mat.length; r++) {
      if (r != row && mat[r][col] == 1) {
        return false;
      }
    }

    for (int c = 0; c < mat[0].length; c++) {
      if (c != col && mat[row][c] == 1) {
        return false;
      }
    }
    return true;
  }
}
