package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1662CheckIfTwoStringArraysAreEquivalentTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1662CheckIfTwoStringArraysAreEquivalentTest {

  private final P1662CheckIfTwoStringArraysAreEquivalent p1662 =
      new P1662CheckIfTwoStringArraysAreEquivalent();

  @ParameterizedTest
  @MethodSource
  void examples(String[] word1, String[] word2, boolean expected) {
    assertThat(p1662.arrayStringsAreEqual(word1, word2)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new String[] {"ab", "c"}, new String[] {"a", "bc"}, true),
        Arguments.of(new String[] {"a", "cb"}, new String[] {"ab", "c"}, false),
        Arguments.of(new String[] {"abc", "d", "defg"}, new String[] {"abcddefg"}, true));
  }
}
