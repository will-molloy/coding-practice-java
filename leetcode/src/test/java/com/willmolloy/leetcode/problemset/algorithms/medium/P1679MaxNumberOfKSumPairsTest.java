package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1679MaxNumberOfKSumPairsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1679MaxNumberOfKSumPairsTest {

  private final P1679MaxNumberOfKSumPairs p1679 = new P1679MaxNumberOfKSumPairs();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int k, int expected) {
    assertThat(p1679.maxOperations(nums, k)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 3, 4}, 5, 2), Arguments.of(new int[] {3, 1, 3, 4, 3}, 6, 1));
  }
}
