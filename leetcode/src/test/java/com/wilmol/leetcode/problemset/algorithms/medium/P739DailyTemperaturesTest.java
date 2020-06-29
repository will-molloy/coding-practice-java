package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P739DailyTemperaturesTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P739DailyTemperaturesTest {

  @ParameterizedTest
  @MethodSource("p739")
  void example(P739DailyTemperatures p739) {
    assertThat(p739.dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73}))
        .asList()
        .containsExactly(1, 1, 4, 2, 1, 1, 0, 0)
        .inOrder();
  }

  @ParameterizedTest
  @MethodSource("p739")
  void tempMustBeLargerNotEqual(P739DailyTemperatures p739) {
    assertThat(p739.dailyTemperatures(new int[] {89, 62, 70, 58, 47, 47, 46, 76, 100, 70}))
        .asList()
        .containsExactly(8, 1, 5, 4, 3, 2, 1, 1, 0, 0)
        .inOrder();
  }

  static Stream<P739DailyTemperatures> p739() {
    return Stream.of(new P739DailyTemperatures.Map(), new P739DailyTemperatures.Stack());
  }
}
