package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P33DigitCancellingFractionsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P33DigitCancellingFractionsTest {

  @Test
  void nonTrivialFractionsLessThanOneWithTwoDigitsInNumeratorAndDenominator() {
    assertThat(P33DigitCancellingFractions.solve()).isEqualTo(100);
  }
}
