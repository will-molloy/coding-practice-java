package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P35CircularPrimesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P35CircularPrimesTest {

  @Test
  void countBelow100() {
    assertThat(P35CircularPrimes.numCircularPrimesBelow(100)).isEqualTo(13L);
  }

  @Test
  void countBelow1M() {
    assertThat(P35CircularPrimes.numCircularPrimesBelow(1_000_000)).isEqualTo(55L);
  }
}
