package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import java.util.OptionalLong;
import org.junit.jupiter.api.Test;

/**
 * P12HighlyDivisibleTriangleNumberTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P12HighlyDivisibleTriangleNumberTest {

  private final P12HighlyDivisibleTriangleNumber highlyDivisibleTriangleNumber =
      new P12HighlyDivisibleTriangleNumber();

  @Test
  void above5Divisors() {
    assertThat(highlyDivisibleTriangleNumber.apply(5)).isEqualTo(OptionalLong.of(28));
  }

  @Test
  void above500Divisors() {
    assertThat(highlyDivisibleTriangleNumber.apply(500)).isEqualTo(OptionalLong.of(76_576_500));
  }
}
