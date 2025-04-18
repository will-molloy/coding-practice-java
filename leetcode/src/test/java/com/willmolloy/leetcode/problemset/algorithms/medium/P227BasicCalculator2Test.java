package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P227BasicCalculator2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P227BasicCalculator2Test {

  private final P227BasicCalculator2 p227 = new P227BasicCalculator2();

  @ParameterizedTest
  @MethodSource
  void examples(String s, int expected) {
    assertThat(p227.calculate(s)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("3+2*2", 7), Arguments.of(" 3/2 ", 1), Arguments.of(" 3+5 / 2 ", 5));
  }
}
