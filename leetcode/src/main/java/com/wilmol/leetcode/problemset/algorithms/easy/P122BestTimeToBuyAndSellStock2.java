package com.wilmol.leetcode.problemset.algorithms.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii>https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii</a>
 *
 * <p>Key: greedy algorithm
 *
 * @see P121BestTimeToBuyAndSellStock
 * @see com.wilmol.leetcode.problemset.algorithms.hard.P123BestTimeToBuyAndSellStock3
 * @see com.wilmol.leetcode.problemset.algorithms.hard.P188BestTimeToBuyAndSellStock4
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
interface P122BestTimeToBuyAndSellStock2 {

  int maxProfit(int[] prices);

  /**
   * Brute force approach, try every max profit of all sub ranges of prices. Time limit exceeded.
   *
   * <p>Runtime: O(n<sup>n</sup>) (recurrence T(n) = n T(n) + O(n))
   *
   * <p>Space: O(n) (recursion depth)
   */
  class BruteForce implements P122BestTimeToBuyAndSellStock2 {

    @Override
    public int maxProfit(int[] prices) {
      List<Integer> asList = Arrays.stream(prices).boxed().collect(Collectors.toList());
      return maxProfit(asList);
    }

    private int maxProfit(List<Integer> prices) {
      if (prices.size() <= 1) {
        return 0;
      }
      int maxProfit = 0;
      for (int leftSize = 2; leftSize <= prices.size(); leftSize++) {
        // partition into left/right subrange
        List<Integer> left = prices.subList(0, leftSize);
        List<Integer> right = prices.subList(leftSize, prices.size());
        // get max profit from left subrange
        int leftProfit = maxProfit0(left);
        // recursively get max profit from right subrange
        int rightProfit = maxProfit(right);
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
   * One pass.
   *
   * <p>Runtime: O(n)
   *
   * <p>Space: O(1)
   */
  class Linear implements P122BestTimeToBuyAndSellStock2 {

    @Override
    public int maxProfit(int[] prices) {
      int maxProfit = 0;
      for (int i = 1; i < prices.length; i++) {
        // can solve by finding all consecutive valleys/peaks
        // as this must maximise the profit

        // but this can be simplified further by only comparing today to previous day
        // works because difference between multiple days is the same as summing the differences
        // between single days
        // therefore covers both (all) cases:
        // - where max is buying/selling in pairs of 2 days
        // - where max is buying/selling in pairs of >2 days
        // e.g. for [1,2,3,4,5]; 5 - 1 = (5 - 4) + (4 - 3) + (3 - 2) + (2 - 1) = 4
        int sell = prices[i];
        int buy = prices[i - 1];
        if (sell > buy) {
          maxProfit += sell - buy;
        }
      }
      return maxProfit;
    }
  }
}
