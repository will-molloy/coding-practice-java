package com.willmolloy.leetcode.problemset.algorithms.hard;

/**
 * <a
 * href=https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv>https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv</a>
 *
 * <p>Runtime: O(kn)
 *
 * <p>Space: O(kn)
 *
 * <p>Key: dynamic programming
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P121BestTimeToBuyAndSellStock
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P122BestTimeToBuyAndSellStock2
 * @see P123BestTimeToBuyAndSellStock3
 * @see
 *     com.willmolloy.leetcode.problemset.algorithms.medium.P309BestTimeToBuyAndSellStockWithCooldown
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P188BestTimeToBuyAndSellStock4 {

  public int maxProfit(int maxTransactions, int[] prices) {
    if (prices.length <= 1 || maxTransactions == 0) {
      return 0;
    }
    if (maxTransactions >= prices.length / 2) {
      return maxProfitNoTransactionLimit(prices);
    }
    // dp[k][i] represents:
    // - k: number of transactions allowed
    // - i: days/price points considered
    // base cases:
    // - dp[0][i] = 0; 0 profit for no transactions
    // - dp[k][0] = 0; 0 profit on day 1 (no opportunity to sell yet)
    // recursive case:
    // - dp[k][i] = max(dp[k][i-1], prices[i] - prices[j] + dp[k-1][j-1]), j=[0..i-1]
    // i.e. profit is either same as previous day or selling with 1 less transaction allowed
    int[][] dp = new int[maxTransactions + 1][prices.length];
    for (int k = 1; k <= maxTransactions; k++) {
      int minBuy = prices[0];
      for (int i = 1; i < prices.length; i++) {
        minBuy = Math.min(minBuy, prices[i] - dp[k - 1][i - 1]);
        dp[k][i] = Math.max(dp[k][i - 1], prices[i] - minBuy);
      }
    }
    return dp[maxTransactions][prices.length - 1];
  }

  // same as P122, where am allowed any number of transactions
  // needed to avoid MLE when creating dp[][] array
  private int maxProfitNoTransactionLimit(int[] prices) {
    int profit = 0;
    for (int i = 1; i < prices.length; i++) {
      int buy = prices[i - 1];
      int sell = prices[i];
      profit += Math.max(0, sell - buy);
    }
    return profit;
  }
}
