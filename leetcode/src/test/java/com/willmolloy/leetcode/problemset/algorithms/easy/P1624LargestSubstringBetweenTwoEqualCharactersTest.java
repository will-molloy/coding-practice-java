package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1624LargestSubstringBetweenTwoEqualCharactersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1624LargestSubstringBetweenTwoEqualCharactersTest {

  private final P1624LargestSubstringBetweenTwoEqualCharacters p1624 =
      new P1624LargestSubstringBetweenTwoEqualCharacters();

  @ParameterizedTest
  @MethodSource
  void examples(String s, int expected) {
    assertThat(p1624.maxLengthBetweenEqualCharacters(s)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("aa", 0),
        Arguments.of("abca", 2),
        Arguments.of("cbzxy", -1),
        Arguments.of("cabbac", 4));
  }
}
