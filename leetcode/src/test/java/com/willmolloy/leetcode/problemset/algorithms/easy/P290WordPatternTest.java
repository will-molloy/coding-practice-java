package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P290WordPatternTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P290WordPatternTest {

  private final P290WordPattern p290 = new P290WordPattern();

  @ParameterizedTest
  @MethodSource
  void examples(String pattern, String str, boolean expected) {
    assertThat(p290.wordPattern(pattern, str)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("abba", "dog cat cat dog", true),
        Arguments.of("abba", "dog cat cat fish", false),
        Arguments.of("aaaa", "dog cat cat dog", false),
        Arguments.of("abba", "dog dog dog dog", false));
  }
}
