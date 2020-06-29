package com.wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P188BestTimeToBuyAndSellStock4Test.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P188BestTimeToBuyAndSellStock4Test {

  private final P188BestTimeToBuyAndSellStock4 fun = new P188BestTimeToBuyAndSellStock4();

  @Test
  void example1() {
    assertThat(fun.maxProfit(2, new int[] {2, 4, 1})).isEqualTo(2);
  }

  @Test
  void example2() {
    assertThat(fun.maxProfit(2, new int[] {3, 2, 6, 5, 0, 3})).isEqualTo(7);
  }

  @Test
  void sellTwice() {
    assertThat(fun.maxProfit(2, new int[] {1, 5, 1, 6, 1, 7})).isEqualTo(11);
  }

  @Test
  void sellThrice() {
    assertThat(fun.maxProfit(3, new int[] {1, 5, 1, 6, 1, 7})).isEqualTo(15);
  }

  @Test
  void cantSell() {
    assertThat(fun.maxProfit(0, new int[] {1, 5, 1, 6, 1, 7})).isEqualTo(0);
  }

  @Test
  void singlePrice() {
    assertThat(fun.maxProfit(1, new int[] {1})).isEqualTo(0);
  }
}
