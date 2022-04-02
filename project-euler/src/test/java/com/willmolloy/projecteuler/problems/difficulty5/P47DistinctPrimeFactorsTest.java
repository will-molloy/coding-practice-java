package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P47DistinctPrimeFactorsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P47DistinctPrimeFactorsTest {

  @Test
  void firstOfTwoConsecutiveWithTwoDistinctPrimeFactorsEach() {
    assertThat(P47DistinctPrimeFactors.firstOfSetWithSizeNAndNDistinctConsecutivePrimeFactors(2))
        .isEqualTo(14);
  }

  @Test
  void firstOfThreeConsecutiveWithThreeDistinctPrimeFactorsEach() {
    assertThat(P47DistinctPrimeFactors.firstOfSetWithSizeNAndNDistinctConsecutivePrimeFactors(3))
        .isEqualTo(644);
  }

  @Test
  void firstOfFourConsecutiveWithFourDistinctPrimeFactorsEach() {
    assertThat(P47DistinctPrimeFactors.firstOfSetWithSizeNAndNDistinctConsecutivePrimeFactors(4))
        .isEqualTo(134_043);
  }
}
