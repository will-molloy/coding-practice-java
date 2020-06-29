package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/coin-change-2>https://leetcode.com/problems/coin-change-2</a>
 *
 * <p>Key: Figuring out the dp formula was harder than the previous problem ({@link
 * P322CoinChange}); number of ways = number of ways with + number of ways without. Very similar to
 * knapsack problem.
 *
 * @see P322CoinChange
 * @see <a
 *     href=https://en.wikipedia.org/wiki/Knapsack_problem>https://en.wikipedia.org/wiki/Knapsack_problem</a>
 * @see <a
 *     href=https://en.wikipedia.org/wiki/Dynamic_programming>https://en.wikipedia.org/wiki/Dynamic_programming</a>
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
interface P518CoinChange2 {

  int change(int n, int[] coins);

  /**
   * Initial solution, time efficient bottom-up dp but uses more space than necessary.
   *
   * <p>Runtime: O(n * coins)
   *
   * <p>Space: O(n * coins)
   */
  class InitialDp implements P518CoinChange2 {

    @Override
    public int change(int n, int[] coins) {
      // dp[i][j] = ways to create amount j considering all coin:coins[0, i)
      int[][] dp = new int[coins.length + 1][n + 1];

      // base case
      // 1 way to make amount=0 given any set of coins
      for (int i = 0; i <= coins.length; i++) {
        dp[i][0] = 1;
      }

      // recursive case
      // can transition into dp[i][j] from dp[i - 1][j] (i.e. not using coin coins[i-1]) OR from
      // dp[i][j - coins[i-1]] (i.e. using coin coins[i-1])
      // therefore dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i-1]]
      for (int i = 1; i <= coins.length; i++) {
        for (int j = 1; j <= n; j++) {
          // need index check because coin coins[i-1] may be unusable at amount j
          int withLastCoin = j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0;
          int withoutLastCoin = dp[i - 1][j];
          dp[i][j] = withLastCoin + withoutLastCoin;
        }
      }
      return dp[coins.length][n];
    }
  }

  /**
   * Optimised solution, realises the dp only depends on the <b>above row same column</b> and prior
   * columns, so can use and update a 1d dp array instead.
   *
   * <p>Runtime: O(n * coins)
   *
   * <p>Space: O(n)
   */
  class OptimisedDp implements P518CoinChange2 {

    @Override
    public int change(int n, int[] coins) {
      // dp[i] = ways to make amount i
      int[] dp = new int[n + 1];

      // base case
      // 1 way to make amount=0
      dp[0] = 1;

      // recursive case
      // same as above solution
      for (int coin : coins) {
        // start at i=coin to avoid negative index check
        // NOTE it doesn't matter if coins array is sorted or not (can consider coins in any order,
        // as long as all are eventually considered)
        for (int i = coin; i <= n; i++) {
          dp[i] += dp[i - coin];
        }
      }
      return dp[n];
    }
  }
}
