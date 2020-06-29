package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P46GoldbachsOtherConjectureTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P46GoldbachsOtherConjectureTest {

  @Test
  void firstOddCompositeNotSumOfPrimeAndTwiceASquare() {
    assertThat(P46GoldbachsOtherConjecture.firstOddCompositeNotSumOfPrimeAndTwiceASquare())
        .isEqualTo(5777);
  }
}
