package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P121BestTimeToBuyAndSellStockTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P121BestTimeToBuyAndSellStockTest {

  private final P121BestTimeToBuyAndSellStock fun = new P121BestTimeToBuyAndSellStock();

  @Test
  void example1() {
    assertThat(fun.maxProfit(new int[] {7, 1, 5, 3, 6, 4})).isEqualTo(5);
  }

  @Test
  void example2() {
    assertThat(fun.maxProfit(new int[] {7, 6, 4, 3, 1})).isEqualTo(0);
  }
}
