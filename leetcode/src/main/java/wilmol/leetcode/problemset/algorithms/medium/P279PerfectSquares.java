package wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wilmol on 2020-04-24.
 *
 * <p><a
 * href=https://leetcode.com/problems/perfect-squares>https://leetcode.com/problems/perfect-squares/</a>
 *
 * <p>Difficulty: Medium.
 *
 * <p>Runtime: O(n<sup>3/2</sup>)
 *
 * <p>Space: O(n<sup>3/2</sup>)
 *
 * <p>Key: Using dp the problem is the same as {@link P322CoinChange}.
 *
 * @see P322CoinChange
 */
class P279PerfectSquares {

  public int numSquares(int n) {
    // set of squares up to n
    // e.g. n = 12 then consider [1, 4, 9] only
    List<Integer> squares = new ArrayList<>();
    for (int i = 1; i * i <= n; i++) {
      squares.add(i * i);
    }

    // then do dp
    // dp[i][j] = considering ith numbers in the set to sum to j
    int[][] dp = new int[squares.size()][n + 1];

    for (int j = 1; j <= n; j++) {
      // case where only '1' is considered
      dp[0][j] = j;
    }

    // dp[i][j] = min(dp[i - 1][j], dp[i][j - last in set] + 1)
    // i.e. take old answer (which considered smaller set of squares available) or use new square
    // available
    for (int i = 1; i < squares.size(); i++) {
      for (int j = 1; j <= n; j++) {
        int lastInSet = squares.get(i);
        if (lastInSet <= j) {
          dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - lastInSet] + 1);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[squares.size() - 1][n];
  }
}
