package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P459RepeatedSubstringPatternTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P459RepeatedSubstringPatternTest {

  private final P459RepeatedSubstringPattern p459 = new P459RepeatedSubstringPattern();

  @ParameterizedTest
  @MethodSource
  void examples(String s, boolean expected) {
    assertThat(p459.repeatedSubstringPattern(s)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("abab", true), Arguments.of("aba", false), Arguments.of("abcabcabcabc", true));
  }
}
