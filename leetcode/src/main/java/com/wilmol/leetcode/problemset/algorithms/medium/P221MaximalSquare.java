package com.wilmol.leetcode.problemset.algorithms.medium;

import static java.lang.Math.max;

import java.util.stream.IntStream;

/**
 * Created by wilmol on 2020-04-24.
 *
 * <p><a
 * href=https://leetcode.com/problems/maximal-square>https://leetcode.com/problems/maximal-square/</a>
 *
 * <p>Difficulty: Medium.
 *
 * <p>Runtime: O(nm)
 *
 * <p>Space: O(nm)
 *
 * <p>Key: Tracking side length in the dp (since it's a square).
 *
 * @see P1277CountSquareSubmatricesWithAllOnes
 */
class P221MaximalSquare {

  public int maximalSquare(char[][] matrix) {
    int n = matrix.length;
    if (n == 0) {
      return 0;
    }
    int m = matrix[0].length;

    // dp[i][j] = longest square side length for square with bottom right corner at matrix[i][j]
    int[][] dp = new int[n][m];

    // dp[i][j] = 0 (if matrix[i][j] = 0)
    // dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1 (if matrix[i][j] = 1)
    // i.e. if unable to extend square (matrix[i - 1][j] or matrix[i][j - 1] = 0) then create new
    // square (size 1)
    // but if are able to extend square then essentially takes dp[i - 1][j - 1] and extends side
    // length by 1
    // (more complicated cases e.g. min(2, 2, 1) mean the square formed by taking matrix[i][j] can't
    // include those other squares anyway)

    int longest = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] == '1') {
          if (i == 0 || j == 0) {
            // base case, first row and column are unable to extend any square
            dp[i][j] = 1;
          } else {
            // recursive case, explained above
            dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
          }
          // update longest now so don't have to iterate over dp array again later
          longest = max(longest, dp[i][j]);
        }
      }
    }
    return longest * longest;
  }

  private static int min(int... ints) {
    return IntStream.of(ints).min().getAsInt();
  }
}
