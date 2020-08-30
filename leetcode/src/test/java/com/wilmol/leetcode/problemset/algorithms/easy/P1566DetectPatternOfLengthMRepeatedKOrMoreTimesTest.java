package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1566DetectPatternOfLengthMRepeatedKOrMoreTimesTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1566DetectPatternOfLengthMRepeatedKOrMoreTimesTest {

  private final P1566DetectPatternOfLengthMRepeatedKOrMoreTimes p1566 =
      new P1566DetectPatternOfLengthMRepeatedKOrMoreTimes();

  @ParameterizedTest
  @MethodSource
  void examples(int[] arr, int m, int k, boolean expected) {
    assertThat(p1566.containsPattern(arr, m, k)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 4, 4, 4, 4}, 1, 3, true),
        Arguments.of(new int[] {1, 2, 1, 2, 1, 1, 1, 3}, 2, 2, true),
        Arguments.of(new int[] {1, 2, 1, 2, 1, 3}, 2, 3, false),
        Arguments.of(new int[] {1, 2, 3, 1, 2}, 2, 2, false),
        Arguments.of(new int[] {2, 2, 2, 2}, 2, 3, false));
  }

  @Test
  void wa1MustIncludeEndOfArray() {
    assertThat(p1566.containsPattern(new int[] {2, 2}, 1, 2)).isTrue();
  }
}
