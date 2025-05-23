package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P27QuadraticPrimesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P27QuadraticPrimesTest {

  @Test
  void testBothLimits1000() {
    assertThat(new P27QuadraticPrimes().apply(1000, 1000)).isEqualTo(-59231);
  }
}
