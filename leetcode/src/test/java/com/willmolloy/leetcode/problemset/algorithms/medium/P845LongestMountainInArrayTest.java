package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P845LongestMountainInArrayTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P845LongestMountainInArrayTest {

  private final P845LongestMountainInArray p845 = new P845LongestMountainInArray();

  @ParameterizedTest
  @MethodSource
  void examples(int[] a, int expected) {
    assertThat(p845.longestMountain(a)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {2, 1, 4, 7, 3, 2, 5}, 5), Arguments.of(new int[] {2, 2, 2}, 0));
  }
}
