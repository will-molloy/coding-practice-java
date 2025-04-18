package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1546MaximumNumberOfNonOverlappingSubarrayWithSumEqualsTargetTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1546MaximumNumberOfNonOverlappingSubarrayWithSumEqualsTargetTest {

  private final P1546MaximumNumberOfNonOverlappingSubarrayWithSumEqualsTarget p1546 =
      new P1546MaximumNumberOfNonOverlappingSubarrayWithSumEqualsTarget();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int target, int expected) {
    assertThat(p1546.maxNonOverlapping(nums, target)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 1, 1, 1, 1}, 2, 2),
        Arguments.of(new int[] {-1, 3, 5, 1, 4, 2, -9}, 6, 2),
        Arguments.of(new int[] {-2, 6, 6, 3, 5, 4, 1, 2, 8}, 10, 3),
        Arguments.of(new int[] {0, 0, 0}, 0, 3));
  }
}
