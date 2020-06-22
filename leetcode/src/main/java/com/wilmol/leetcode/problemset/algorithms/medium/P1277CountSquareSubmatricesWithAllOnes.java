package com.wilmol.leetcode.problemset.algorithms.medium;

import static java.lang.Math.min;

/**
 * Created by wilmol on 2020-05-21.
 *
 * <p><a
 * href=https://leetcode.com/problems/count-square-submatrices-with-all-ones>https://leetcode.com/problems/count-square-submatrices-with-all-ones/</a>
 *
 * <p>Difficulty: Medium.
 *
 * <p>Runtime: O(nm)
 *
 * <p>Space: O(1)
 *
 * <p>Key: Dynamic programming to compute square side lengths (same process as {@link
 * P221MaximalSquare}) and realising that adding these side lengths is the answer.
 *
 * @see P221MaximalSquare
 */
class P1277CountSquareSubmatricesWithAllOnes {

  public int countSquares(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;

    // same as the max square in matrix problem
    // dp[row][col] = min(dp[row-1][col], dp[row][col-1], dp[row-1][col-1]) + 1
    // i.e. write side length of each square to bottom right cell of the square

    for (int row = 1; row < n; row++) {
      for (int col = 1; col < m; col++) {
        if (matrix[row][col] == 1) {
          matrix[row][col] =
              min(min(matrix[row - 1][col], matrix[row][col - 1]), matrix[row - 1][col - 1]) + 1;
        }
      }
    }

    // can just sum up the side lengths
    // works because e.g. side length 2 will be counted twice (once as 2x2, and once as 1x1) etc.
    int count = 0;
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < m; col++) {
        count += matrix[row][col];
      }
    }
    return count;
  }
}
