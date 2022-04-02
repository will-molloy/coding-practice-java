package com.willmolloy.leetcode.problemset.algorithms.hard;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii>https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii</a>
 *
 * <p>Key: dynamic programming
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P121BestTimeToBuyAndSellStock
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P122BestTimeToBuyAndSellStock2
 * @see P188BestTimeToBuyAndSellStock4
 * @see
 *     com.willmolloy.leetcode.problemset.algorithms.medium.P309BestTimeToBuyAndSellStockWithCooldown
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface P123BestTimeToBuyAndSellStock3 {

  int maxProfit(int[] prices);

  /**
   * Brute force approach, try every max profit of all sub ranges of prices. Time limit exceeded.
   *
   * <p>Runtime: O(n<sup>2</sup>)
   *
   * <p>Space: O(1)
   */
  class BruteForce implements P123BestTimeToBuyAndSellStock3 {

    @Override
    public int maxProfit(int[] prices) {
      List<Integer> asList = Arrays.stream(prices).boxed().collect(Collectors.toList());
      return maxProfit(asList);
    }

    private int maxProfit(List<Integer> prices) {
      int maxProfit = 0;
      for (int leftSize = 2; leftSize <= prices.size(); leftSize++) {
        // partition into left/right
        List<Integer> leftPartition = prices.subList(0, leftSize);
        List<Integer> rightPartition = prices.subList(leftSize, prices.size());
        // compute profit for each (max 2 transactions, 1 each)
        int leftProfit = maxProfit0(leftPartition);
        int rightProfit = maxProfit0(rightPartition);
        // update max
        maxProfit = Math.max(maxProfit, leftProfit + rightProfit);
      }
      return maxProfit;
    }

    private int maxProfit0(List<Integer> prices) {
      int maxProfit = 0;
      int minBuy = Integer.MAX_VALUE;
      for (int price : prices) {
        minBuy = Math.min(minBuy, price);
        maxProfit = Math.max(maxProfit, price - minBuy);
      }
      return maxProfit;
    }
  }

  /**
   * One-pass solution.
   *
   * <p>Runtime: O(n)
   *
   * <p>Space: O(1)
   */
  class Linear implements P123BestTimeToBuyAndSellStock3 {

    @Override
    public int maxProfit(int[] prices) {
      int buy1 = Integer.MAX_VALUE;
      int buy2 = Integer.MAX_VALUE;
      int sell1 = 0;
      int sell2 = 0;
      for (int price : prices) {
        // maximise profit of first transaction (same as original problem, P121)
        buy1 = Math.min(buy1, price);
        sell1 = Math.max(sell1, price - buy1);
        // include cost of first transaction in second transaction
        // then profit will include both
        buy2 = Math.min(buy2, price - sell1);
        sell2 = Math.max(sell2, price - buy2);
      }
      return sell2;
    }
  }
}
