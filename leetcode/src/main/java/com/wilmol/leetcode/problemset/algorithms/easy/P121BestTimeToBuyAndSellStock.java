package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/best-time-to-buy-and-sell-stock>https://leetcode.com/problems/best-time-to-buy-and-sell-stock</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: tracking current minimum/maximum
 *
 * @see P122BestTimeToBuyAndSellStock2
 * @see com.wilmol.leetcode.problemset.algorithms.hard.P123BestTimeToBuyAndSellStock3
 * @see com.wilmol.leetcode.problemset.algorithms.hard.P188BestTimeToBuyAndSellStock4
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P309BestTimeToBuyAndSellStockWithCooldown
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P121BestTimeToBuyAndSellStock {

  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int minBuy = Integer.MAX_VALUE;
    for (int price : prices) {
      minBuy = Math.min(minBuy, price);
      maxProfit = Math.max(maxProfit, price - minBuy);
    }
    return maxProfit;
  }
}
