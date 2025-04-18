package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P46GoldbachsOtherConjectureTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P46GoldbachsOtherConjectureTest {

  @Test
  void firstOddCompositeNotSumOfPrimeAndTwiceASquare() {
    assertThat(P46GoldbachsOtherConjecture.firstOddCompositeNotSumOfPrimeAndTwiceASquare())
        .isEqualTo(5777);
  }
}
