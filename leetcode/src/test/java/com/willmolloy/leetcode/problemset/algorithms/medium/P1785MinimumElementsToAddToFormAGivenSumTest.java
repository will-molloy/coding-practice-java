package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1785MinimumElementsToAddToFormAGivenSumTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1785MinimumElementsToAddToFormAGivenSumTest {

  private final P1785MinimumElementsToAddToFormAGivenSum p1785MinimumElementsToAddToFormAGivenSum =
      new P1785MinimumElementsToAddToFormAGivenSum();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int limit, int goal, int expected) {
    assertThat(p1785MinimumElementsToAddToFormAGivenSum.minElements(nums, limit, goal))
        .isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, -1, 1}, 3, -4, 2),
        Arguments.of(new int[] {1, -10, 9, 1}, 100, 0, 1));
  }
}
