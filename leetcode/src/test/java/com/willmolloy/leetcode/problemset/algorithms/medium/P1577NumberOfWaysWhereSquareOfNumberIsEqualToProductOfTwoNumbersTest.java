package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1577NumberOfWaysWhereSquareOfNumberIsEqualToProductOfTwoNumbersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1577NumberOfWaysWhereSquareOfNumberIsEqualToProductOfTwoNumbersTest {

  private final P1577NumberOfWaysWhereSquareOfNumberIsEqualToProductOfTwoNumbers p1577 =
      new P1577NumberOfWaysWhereSquareOfNumberIsEqualToProductOfTwoNumbers();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums1, int[] nums2, int expected) {
    assertThat(p1577.numTriplets(nums1, nums2)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {7, 4}, new int[] {5, 2, 8, 9}, 1),
        Arguments.of(new int[] {1, 1}, new int[] {1, 1, 1}, 9),
        Arguments.of(new int[] {7, 7, 8, 3}, new int[] {1, 2, 9, 7}, 2),
        Arguments.of(new int[] {4, 7, 9, 11, 23}, new int[] {3, 5, 1024, 12, 18}, 0));
  }
}
