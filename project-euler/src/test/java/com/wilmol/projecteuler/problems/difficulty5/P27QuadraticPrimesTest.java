package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P27QuadraticPrimesTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P27QuadraticPrimesTest {

  @Test
  void testBothLimits1000() {
    assertThat(new P27QuadraticPrimes().apply(1000, 1000)).isEqualTo(-59231);
  }
}
