package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P35CircularPrimesTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P35CircularPrimesTest {

  @Test
  void countBelow100() {
    assertThat(P35CircularPrimes.numCircularPrimesBelow(100)).isEqualTo(13L);
  }

  @Test
  void countBelow1M() {
    assertThat(P35CircularPrimes.numCircularPrimesBelow(1_000_000)).isEqualTo(55L);
  }
}
