package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1081SmallestSubsequenceOfDistinctCharactersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1081SmallestSubsequenceOfDistinctCharactersTest {

  private final P1081SmallestSubsequenceOfDistinctCharacters p1081 =
      new P1081SmallestSubsequenceOfDistinctCharacters();

  @ParameterizedTest
  @MethodSource
  void examples(String s, String expected) {
    assertThat(p1081.smallestSubsequence(s)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(Arguments.of("bcabc", "abc"), Arguments.of("cbacdcbc", "acdb"));
  }
}
