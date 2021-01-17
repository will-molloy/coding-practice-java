package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P215KthLargestElementInAnArrayTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P215KthLargestElementInAnArrayTest {

  private final P215KthLargestElementInAnArray p215KthLargestElementInAnArray =
      new P215KthLargestElementInAnArray();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int k, int expected) {
    assertThat(p215KthLargestElementInAnArray.findKthLargest(nums, k)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {3, 2, 1, 5, 6, 4}, 2, 5),
        Arguments.of(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4, 4));
  }
}
