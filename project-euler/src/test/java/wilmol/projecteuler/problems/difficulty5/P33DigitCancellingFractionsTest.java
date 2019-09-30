package wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by will on 2019-04-14 at 7:35 PM. */
class P33DigitCancellingFractionsTest {

  @Test
  void nonTrivialFractionsLessThanOneWithTwoDigitsInNumeratorAndDenominator() {
    assertThat(P33DigitCancellingFractions.solve()).isEqualTo(100);
  }
}
