package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by will on 2019-04-19 at 3:59 PM. */
class P37TruncatablePrimesTest {

  @Test
  void truncatablePrimesSumTest() {
    assertThat(P37TruncatablePrimes.truncatablePrimesSum()).isEqualTo(748317L);
  }
}
