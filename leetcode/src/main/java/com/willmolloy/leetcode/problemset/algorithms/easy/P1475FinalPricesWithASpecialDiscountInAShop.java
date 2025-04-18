package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop>https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/</a>
 *
 * <p>Runtime: O(n<sup>2</sup>) TODO can do O(n) with stack (monotonic queue)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key idea: Simulate problem statement.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1475FinalPricesWithASpecialDiscountInAShop {

  public int[] finalPrices(int[] prices) {
    int n = prices.length;

    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      boolean discount = false;
      for (int j = i + 1; j < n; j++) {
        if (!discount && prices[j] <= prices[i]) {
          result[i] = prices[i] - prices[j];
          discount = true;
        }
      }
      if (!discount) {
        result[i] = prices[i];
      }
    }
    return result;
  }
}
