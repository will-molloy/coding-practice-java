package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.Arrays;

/**
 * Created by wilmol on 2020-04-13.
 *
 * <p><a
 * href=https://leetcode.com/problems/coin-change>https://leetcode.com/problems/coin-change</a>
 *
 * <p>Runtime: O(coins * n)
 *
 * <p>Space: O(n)
 *
 * <p>Key: Getting the dp formula was straight forward. Hard part was handling the case when amounts
 * couldn't be created; most elegant way to handle this was setting {@code dp[i]} to {@code n + 1}
 * (a local maximum) initially. This allowed {@code Math.min} to be used when assigning {@code
 * dp[i]} without risk of overflows.
 *
 * @see P518CoinChange2
 */
class P322CoinChange {

  public int coinChange(int[] coins, int n) {
    // dp[i] = minimum coins required to create amount i
    int[] dp = new int[n + 1];
    Arrays.fill(dp, n + 1);

    // base cases:
    // require no coins to produce amount=0
    dp[0] = 0;

    // recursive case
    // try all coin:coins with coin <= i
    // and find min dp[i - coin] + 1
    // (the states that transition into 'i' are all 'i - coin')
    // e.g. coins = [1, 2, 5, 7]
    // then dp[6] = min(dp[6 - 1], dp[6 - 2], dp[6 - 5]) + 1
    for (int i = 1; i <= n; i++) {
      for (int coin : coins) {
        if (coin > i) {
          continue;
        }
        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
      }
    }

    return dp[n] > n ? -1 : dp[n];
  }
}
