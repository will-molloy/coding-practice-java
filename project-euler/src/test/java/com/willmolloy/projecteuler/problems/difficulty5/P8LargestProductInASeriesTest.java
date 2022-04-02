package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P8LargestProductInASeriesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
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
