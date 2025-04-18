package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/perfect-squares>https://leetcode.com/problems/perfect-squares/</a>
 *
 * <p>Runtime: O(n<sup>3/2</sup>)
 *
 * <p>Space: O(n<sup>3/2</sup>)
 *
 * <p>Key idea: Using dp the problem is the same as {@link P322CoinChange}; first generate squares
 * with array list.
 *
 * @see P322CoinChange
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P279PerfectSquares {

  public int numSquares(int n) {
    // set of squares up to n
    // e.g. n = 12 then consider [1, 4, 9] only
    List<Integer> squares = new ArrayList<>();
    for (int i = 1; i * i <= n; i++) {
      squares.add(i * i);
    }

    // dp[i][j] = considering squares[0, i] and min required to sum to j
    int[][] dp = new int[squares.size()][n + 1];

    // base case
    // numSquares(x) = x when only using 1 squared
    for (int j = 1; j <= n; j++) {
      dp[0][j] = j;
    }

    // recursive case
    // use new square: dp[i][j - new square] + 1
    // dont use new square: dp[i - 1][j]
    // take min of these choices
    for (int i = 1; i < squares.size(); i++) {
      for (int j = 1; j <= n; j++) {
        if (squares.get(i) <= j) {
          dp[i][j] = Math.min(dp[i][j - squares.get(i)] + 1, dp[i - 1][j]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[squares.size() - 1][n];
  }
}
