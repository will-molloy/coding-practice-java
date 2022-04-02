package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P991BrokenCalculatorTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P991BrokenCalculatorTest {

  @ParameterizedTest
  @MethodSource
  void examples(int x, int y, int expected) {
    assertThat(new P991BrokenCalculator().brokenCalc(x, y)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(2, 3, 2),
        Arguments.of(5, 8, 2),
        Arguments.of(3, 10, 3),
        Arguments.of(1024, 1, 1023));
  }
}
