package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by will on 2019-04-20 at 3:37 PM. */
class P46GoldbachsOtherConjectureTest {

  @Test
  void firstOddCompositeNotSumOfPrimeAndTwiceASquare() {
    assertThat(P46GoldbachsOtherConjecture.firstOddCompositeNotSumOfPrimeAndTwiceASquare())
        .isEqualTo(5777);
  }
}
