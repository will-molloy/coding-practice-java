package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee>https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Dynamic programming. 2 states to maintain: not holding stock and holding stock.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P121BestTimeToBuyAndSellStock
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P714BestTimeToBuyAndSellStockWithTransactionFee {

  public int maxProfit(int[] prices, int fee) {
    // 2 states:
    // 1. not holding stock (cash)
    // 2. holding stock
    int cash = 0;
    int hold = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      // sell stock (or do nothing)
      cash = Math.max(cash, hold + prices[i] - fee);
      // buy stock (or do nothing)
      hold = Math.max(hold, cash - prices[i]);
    }
    return cash;
  }
}
