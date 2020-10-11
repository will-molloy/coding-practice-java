package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1614MaximumNestingDepthOfTheParenthesisTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1614MaximumNestingDepthOfTheParenthesisTest {

  private final P1614MaximumNestingDepthOfTheParenthesis p1614 =
      new P1614MaximumNestingDepthOfTheParenthesis();

  @ParameterizedTest
  @MethodSource
  void examples(String s, int expected) {
    assertThat(p1614.maxDepth(s)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("(1+(2*3)+((8)/4))+1", 3),
        Arguments.of("(1)+((2))+(((3)))", 3),
        Arguments.of("1+(2*3)/(2-1)", 1),
        Arguments.of("1", 0));
  }
}
