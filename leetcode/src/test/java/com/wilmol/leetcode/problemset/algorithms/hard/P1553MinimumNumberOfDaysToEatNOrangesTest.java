package com.wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;
import static com.wilmol.testlib.TestLib.cartesianProduct;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1553MinimumNumberOfDaysToEatNOrangesTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1553MinimumNumberOfDaysToEatNOrangesTest {

  @ParameterizedTest
  @MethodSource
  void examples(P1553MinimumNumberOfDaysToEatNOranges p1553, int n, int expected) {
    assertThat(p1553.minDays(n)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return cartesianProduct(p1553(), examplesArgs());
  }

  private static Stream<Arguments> examplesArgs() {
    return Stream.of(
        Arguments.of(10, 4), Arguments.of(6, 3), Arguments.of(1, 1), Arguments.of(56, 6));
  }

  private static Stream<P1553MinimumNumberOfDaysToEatNOranges> p1553() {
    return Stream.of(
        new P1553MinimumNumberOfDaysToEatNOranges.Dp(),
        new P1553MinimumNumberOfDaysToEatNOranges.Bfs());
  }
}
