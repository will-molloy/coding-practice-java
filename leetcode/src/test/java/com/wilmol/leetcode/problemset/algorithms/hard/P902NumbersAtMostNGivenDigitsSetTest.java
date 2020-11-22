package com.wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P902NumbersAtMostNGivenDigitsSetTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P902NumbersAtMostNGivenDigitsSetTest {

  private final P902NumbersAtMostNGivenDigitsSet p902 = new P902NumbersAtMostNGivenDigitsSet();

  @ParameterizedTest
  @MethodSource
  void examples(String[] digits, int n, int expected) {
    assertThat(p902.atMostNGivenDigitSet(digits, n)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new String[] {"1", "3", "5", "7"}, 100, 20),
        Arguments.of(new String[] {"1", "4", "9"}, 1000000000, 29523),
        Arguments.of(new String[] {"7"}, 8, 1));
  }

  @Test
  void coversN() {
    assertThat(p902.atMostNGivenDigitSet(new String[] {"1", "3", "5", "7"}, 357)).isEqualTo(48);
  }

  @Test
  void doesntCoverN() {
    assertThat(p902.atMostNGivenDigitSet(new String[] {"1", "3"}, 357)).isEqualTo(14);
  }
}
