package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import java.util.Optional;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.jupiter.api.Test;

/**
 * P9SpecialPythagoreanTripletTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P9SpecialPythagoreanTripletTest {

  private final P9SpecialPythagoreanTriplet specialPythagoreanTriplet =
      new P9SpecialPythagoreanTriplet();

  @Test
  void noSolution() {
    assertThat(specialPythagoreanTriplet.apply(3)).isEqualTo(Optional.empty());
  }

  @Test
  void perimeterOf12() {
    assertThat(specialPythagoreanTriplet.apply(12)).isEqualTo(Optional.of(Triple.of(3, 4, 5)));
  }

  @Test
  void perimeterOf1000() {
    assertThat(specialPythagoreanTriplet.apply(1000))
        .isEqualTo(Optional.of(Triple.of(200, 375, 425)));
  }
}
