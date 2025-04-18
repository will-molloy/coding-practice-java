package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P395LongestSubstringWithAtLeastKRepeatingCharactersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P395LongestSubstringWithAtLeastKRepeatingCharactersTest {

  private final P395LongestSubstringWithAtLeastKRepeatingCharacters p395 =
      new P395LongestSubstringWithAtLeastKRepeatingCharacters();

  @ParameterizedTest
  @MethodSource
  void examples(String s, int k, int expected) {
    assertThat(p395.longestSubstring(s, k)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(Arguments.of("aaabb", 3, 3), Arguments.of("ababbc", 2, 5));
  }
}
