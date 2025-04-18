package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P33DigitCancellingFractionsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P33DigitCancellingFractionsTest {

  @Test
  void nonTrivialFractionsLessThanOneWithTwoDigitsInNumeratorAndDenominator() {
    assertThat(P33DigitCancellingFractions.solve()).isEqualTo(100);
  }
}
