package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1793MaximumScoreOfAGoodSubarrayTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1793MaximumScoreOfAGoodSubarrayTest {

  private final P1793MaximumScoreOfAGoodSubarray p1793MaximumScoreOfAGoodSubarray =
      new P1793MaximumScoreOfAGoodSubarray();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int k, int expected) {
    assertThat(p1793MaximumScoreOfAGoodSubarray.maximumScore(nums, k)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 4, 3, 7, 4, 5}, 3, 15),
        Arguments.of(new int[] {5, 5, 4, 5, 4, 1, 1, 1}, 0, 20));
  }
}
