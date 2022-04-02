package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1593SplitAStringIntoTheMaxNumberOfUniqueSubstringsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1593SplitAStringIntoTheMaxNumberOfUniqueSubstringsTest {

  private final P1593SplitAStringIntoTheMaxNumberOfUniqueSubstrings p1593 =
      new P1593SplitAStringIntoTheMaxNumberOfUniqueSubstrings();

  @ParameterizedTest
  @MethodSource
  void examples(String s, int expected) {
    assertThat(p1593.maxUniqueSplit(s)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(Arguments.of("ababccc", 5), Arguments.of("aba", 2), Arguments.of("aa", 1));
  }
}
