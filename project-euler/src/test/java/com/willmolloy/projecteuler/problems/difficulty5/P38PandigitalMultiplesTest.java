package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P38PandigitalMultiplesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P38PandigitalMultiplesTest {

  @Test
  void maxPandigital1To9() {
    assertThat(P38PandigitalMultiples.max1To9PandigitalNumber()).isEqualTo(932718654);
  }

  @Test
  void maxForNOf3() {
    assertThat(P38PandigitalMultiples.max1To9PandigitalNumberFor(3)).isEqualTo(327654981);
  }

  @Test
  void maxForNOf5() {
    assertThat(P38PandigitalMultiples.max1To9PandigitalNumberFor(5)).isEqualTo(918273645);
  }
}
