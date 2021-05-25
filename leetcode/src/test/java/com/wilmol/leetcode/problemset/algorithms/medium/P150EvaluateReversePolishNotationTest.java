package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P150EvaluateReversePolishNotationTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P150EvaluateReversePolishNotationTest {

  private final P150EvaluateReversePolishNotation p150EvaluateReversePolishNotation =
      new P150EvaluateReversePolishNotation();

  @ParameterizedTest
  @MethodSource
  void examples(String[] tokens, int expected) {
    assertThat(p150EvaluateReversePolishNotation.evalRPN(tokens)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new String[] {"2", "1", "+", "3", "*"}, 9),
        Arguments.of(new String[] {"4", "13", "5", "/", "+"}, 6),
        Arguments.of(
            new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"},
            22));
  }
}
