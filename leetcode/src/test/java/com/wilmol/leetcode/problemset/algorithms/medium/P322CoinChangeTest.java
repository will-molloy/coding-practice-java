package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-13. */
class P322CoinChangeTest {

  private final P322CoinChange fun = new P322CoinChange();

  @Test
  void example1() {
    assertThat(fun.coinChange(new int[] {1, 2, 5}, 11)).isEqualTo(3);
  }

  @Test
  void example2() {
    assertThat(fun.coinChange(new int[] {2}, 3)).isEqualTo(-1);
  }

  @Test
  void largeN() {
    assertThat(fun.coinChange(new int[] {186, 419, 83, 408}, 6249)).isEqualTo(20);
  }

  @Test
  void n0() {
    assertThat(fun.coinChange(new int[] {1, 2, 3}, 0)).isEqualTo(0);
  }
}