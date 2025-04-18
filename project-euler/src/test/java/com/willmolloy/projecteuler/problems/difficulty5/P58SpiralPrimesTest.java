package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P58SpiralPrimesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P58SpiralPrimesTest {

  @Test
  void sideLengthWithLessThan10PercentPrimesOnDiagonals() {
    assertThat(P58SpiralPrimes.solve()).isEqualTo(26241);
  }
}
