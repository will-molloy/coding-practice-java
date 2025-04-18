package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P856ScoreOfParenthesisTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P856ScoreOfParenthesisTest {

  @ParameterizedTest
  @MethodSource
  void examples(String s, int expected) {
    assertThat(new P856ScoreOfParenthesis().scoreOfParentheses(s)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("()", 1),
        Arguments.of("(())", 2),
        Arguments.of("()()", 2),
        Arguments.of("(()(()))", 6));
  }
}
