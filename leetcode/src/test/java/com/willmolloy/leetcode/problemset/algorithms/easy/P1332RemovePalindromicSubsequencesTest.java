package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1332RemovePalindromicSubsequencesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1332RemovePalindromicSubsequencesTest {

  private final P1332RemovePalindromicSubsequences p1332RemovePalindromicSubsequences =
      new P1332RemovePalindromicSubsequences();

  @ParameterizedTest
  @MethodSource
  void examples(String s, int expected) {
    assertThat(p1332RemovePalindromicSubsequences.removePalindromeSub(s)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("ababa", 1),
        Arguments.of("abb", 2),
        Arguments.of("baabb", 2),
        Arguments.of("", 0));
  }
}
