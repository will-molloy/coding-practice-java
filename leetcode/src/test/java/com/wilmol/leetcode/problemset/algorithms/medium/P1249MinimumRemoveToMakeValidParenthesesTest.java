package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1249MinimumRemoveToMakeValidParenthesesTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1249MinimumRemoveToMakeValidParenthesesTest {

  @ParameterizedTest
  @MethodSource
  void examples(String s, String expected) {
    assertThat(new P1249MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid(s))
        .isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("lee(t(c)o)de)", "lee(t(c)o)de"),
        Arguments.of("a)b(c)d", "ab(c)d"),
        Arguments.of("))((", ""),
        Arguments.of("(a(b(c)d)", "(a(bc)d)"));
  }
}
