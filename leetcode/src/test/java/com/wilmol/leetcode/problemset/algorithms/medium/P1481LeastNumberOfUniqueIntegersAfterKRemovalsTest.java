package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1481LeastNumberOfUniqueIntegersAfterKRemovalsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1481LeastNumberOfUniqueIntegersAfterKRemovalsTest {

  private final P1481LeastNumberOfUniqueIntegersAfterKRemovals p1481 =
      new P1481LeastNumberOfUniqueIntegersAfterKRemovals();

  @ParameterizedTest
  @MethodSource
  void examples(int[] arr, int k, int expected) {
    assertThat(p1481.findLeastNumOfUniqueInts(arr, k)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {5, 5, 4}, 1, 1),
        Arguments.of(new int[] {4, 3, 1, 1, 3, 3, 2}, 3, 2));
  }
}
