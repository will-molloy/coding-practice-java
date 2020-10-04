package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P532KDiffPairsInAnArrayTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P532KDiffPairsInAnArrayTest {

  private final P532KDiffPairsInAnArray p532 = new P532KDiffPairsInAnArray();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int k, int expected) {
    assertThat(p532.findPairs(nums, k)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {3, 1, 4, 1, 5}, 2, 2),
        Arguments.of(new int[] {1, 2, 3, 4, 5}, 1, 4),
        Arguments.of(new int[] {1, 3, 1, 5, 4}, 0, 1),
        Arguments.of(new int[] {1, 2, 4, 4, 3, 3, 0, 9, 2, 3}, 3, 2),
        Arguments.of(new int[] {-1, -2, -3}, 1, 2));
  }
}
