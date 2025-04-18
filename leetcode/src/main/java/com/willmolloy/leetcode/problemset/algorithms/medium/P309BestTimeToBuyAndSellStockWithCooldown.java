package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.OptionalInt;

/**
 * <a
 * href=https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown>https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/</a>
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P121BestTimeToBuyAndSellStock
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P122BestTimeToBuyAndSellStock2
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P123BestTimeToBuyAndSellStock3
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P188BestTimeToBuyAndSellStock4
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
sealed interface P309BestTimeToBuyAndSellStockWithCooldown {

  int maxProfit(int[] prices);

  /**
   * Top down approach, gets TLE.
   *
   * <p>Runtime: O(2<sup>n</sup>)
   *
   * <p>Extra memory: O(2<sup>n</sup>)
   *
   * <p>Key idea: Figure out what choices are available.
   */
  final class TopDown implements P309BestTimeToBuyAndSellStockWithCooldown {

    @Override
    public int maxProfit(int[] prices) {
      // choices = [buy, sell, nothing]

      // choices after buy = [sell, nothing]
      // choices after sell = [nothing]
      // choices after nothing = [buy (if not already holding), sell (if holding), nothing]

      return dp(prices, 0, Choice.NOTHING, OptionalInt.empty(), 0);
    }

    private int dp(int[] prices, int i, Choice prevChoice, OptionalInt stock, int profit) {
      if (i == prices.length) {
        return profit;
      }

      int nothing = dp(prices, i + 1, Choice.NOTHING, stock, profit);

      if (prevChoice == Choice.BUY) {
        // must be present, just bought
        int made = prices[i] - stock.getAsInt();
        int sell = dp(prices, i + 1, Choice.SELL, OptionalInt.empty(), profit + made);
        return Math.max(sell, nothing);
      } else if (prevChoice == Choice.SELL) {
        return nothing;
      } else {
        // NOTHING
        if (stock.isPresent()) {
          int made = prices[i] - stock.getAsInt();
          int sell = dp(prices, i + 1, Choice.SELL, OptionalInt.empty(), profit + made);
          return Math.max(sell, nothing);
        } else {
          int buy = dp(prices, i + 1, Choice.BUY, OptionalInt.of(prices[i]), profit);
          return Math.max(buy, nothing);
        }
      }
    }

    private enum Choice {
      BUY,
      SELL,
      NOTHING;
    }
  }

  /**
   * Single pass dp approach.
   *
   * <p>Runtime: O(n)
   *
   * <p>Extra memory: O(n) TODO can easily simplify to O(1)
   *
   * <p>Key idea: Tricky part is encoding the choices. Consider two scenarios:
   *
   * <ol>
   *   <li>Holding stock
   *   <li>Not holding stock
   * </ol>
   *
   * <p>buy = {@code dp[i - 2][0] - prices[i]}, i.e. buy for {@code prices[i]}, subtracting from
   * current profit which must be {@code dp[i - 2][0]} (2 days ago to account for cooldown, in the
   * scenario we aren't already holding the stock).
   *
   * <p>sell = {@code dp[i - 1][1] + prices[i]}, i.e. sell for {@code prices[i]}, adding to current
   * profit which must be {@code dp[i - 1][1]} (yesterday, in the scenario we hold the stock).
   */
  final class BottomUp implements P309BestTimeToBuyAndSellStockWithCooldown {

    @Override
    public int maxProfit(int[] prices) {
      int n = prices.length;
      if (n <= 1) {
        return 0;
      }

      // dp[i][0] = profit not holding stock on day i
      // dp[i][1] = profit holding stock on day i
      int[][] dp = new int[n][2];

      // day 0: nothing
      dp[0][0] = 0;
      // day 0: buy
      dp[0][1] = -prices[0];

      // day 1: max(sell, nothing (keep nothing))
      dp[1][0] = Math.max(dp[0][1] + prices[1], dp[0][0]);
      // day 1: max(buy, nothing (keep holding))
      dp[1][1] = Math.max(dp[0][0] - prices[1], dp[0][1]);

      for (int i = 2; i < n; i++) {
        // max(sell, nothing (keep nothing))
        dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
        // max(buy, nothing (keep holding))
        dp[i][1] = Math.max(dp[i - 2][0] - prices[i], dp[i - 1][1]);
      }

      // for max profit we wouldn't be holding the stock
      return dp[n - 1][0];
    }
  }
}
