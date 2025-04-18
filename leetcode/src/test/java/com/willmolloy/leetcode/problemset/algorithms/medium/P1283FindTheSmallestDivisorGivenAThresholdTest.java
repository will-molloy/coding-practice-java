package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1283FindTheSmallestDivisorGivenAThresholdTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1283FindTheSmallestDivisorGivenAThresholdTest {

  private final P1283FindTheSmallestDivisorGivenAThreshold p1283 =
      new P1283FindTheSmallestDivisorGivenAThreshold();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int threshold, int expected) {
    assertThat(p1283.smallestDivisor(nums, threshold)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 5, 9}, 6, 5),
        Arguments.of(new int[] {2, 3, 5, 7, 11}, 11, 3),
        Arguments.of(new int[] {19}, 5, 4));
  }
}
