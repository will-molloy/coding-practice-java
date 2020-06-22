package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 16/03/2019. */
class P8LargestProductInASeriesTest {

  private final P8LargestProductInASeries largestProductInASeries = new P8LargestProductInASeries();

  @Test
  void test4Adjacent() {
    assertThat(largestProductInASeries.apply(4)).isEqualTo(5_832L);
  }

  @Test
  void test13Adjacent() {
    assertThat(largestProductInASeries.apply(13)).isEqualTo(23_514_624_000L);
  }
}
