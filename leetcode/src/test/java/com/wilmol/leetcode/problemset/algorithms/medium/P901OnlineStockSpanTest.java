package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-05-19. */
class P901OnlineStockSpanTest {

  @Test
  void example() {
    P901OnlineStockSpan stockSpanner = new P901OnlineStockSpan();
    assertThat(stockSpanner.next(100)).isEqualTo(1);
    assertThat(stockSpanner.next(80)).isEqualTo(1);
    assertThat(stockSpanner.next(60)).isEqualTo(1);
    assertThat(stockSpanner.next(70)).isEqualTo(2);
    assertThat(stockSpanner.next(60)).isEqualTo(1);
    assertThat(stockSpanner.next(75)).isEqualTo(4);
    assertThat(stockSpanner.next(85)).isEqualTo(6);
  }
}
