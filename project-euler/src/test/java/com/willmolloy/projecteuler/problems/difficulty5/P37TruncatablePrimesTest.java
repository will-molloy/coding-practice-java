package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P37TruncatablePrimesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P37TruncatablePrimesTest {

  @Test
  void truncatablePrimesSumTest() {
    assertThat(P37TruncatablePrimes.truncatablePrimesSum()).isEqualTo(748317L);
  }
}
