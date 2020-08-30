package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1567MaximumLengthOfSubarrayWithPositiveProductTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1567MaximumLengthOfSubarrayWithPositiveProductTest {

  private final P1567MaximumLengthOfSubarrayWithPositiveProduct p1567 =
      new P1567MaximumLengthOfSubarrayWithPositiveProduct();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int expected) {
    assertThat(p1567.getMaxLen(nums)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, -2, -3, 4}, 4),
        Arguments.of(new int[] {0, 1, -2, -3, -4}, 3),
        Arguments.of(new int[] {-1, -2, -3, 0, 1}, 2),
        Arguments.of(new int[] {-1, 2}, 1),
        Arguments.of(new int[] {1, 2, 3, 5, -6, 4, 0, 10}, 4));
  }

  @Test
  void wa1IntProductOverflows() {
    assertThat(p1567.getMaxLen(new int[] {1000000000, 1000000000})).isEqualTo(2);
  }

  @Test
  void wa2LongProductOverflows() {
    assertThat(
            p1567.getMaxLen(
                new int[] {
                  70, -18, 75, -72, -69, -84, 64, -65, 0, -82, 62, 54, -63, -85, 53, -60, -59, 29,
                  32, 59, -54, -29, -45, 0, -10, 22, 42, -37, -16, 0, -7, -76, -34, 37, -10, 2, -59,
                  -24, 85, 45, -81, 56, 86
                }))
        .isEqualTo(14);
  }
}
