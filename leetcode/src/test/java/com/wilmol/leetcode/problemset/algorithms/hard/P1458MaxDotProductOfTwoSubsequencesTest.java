package com.wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2020-05-24. */
class P1458MaxDotProductOfTwoSubsequencesTest {

  private final P1458MaxDotProductOfTwoSubsequences p1458 =
      new P1458MaxDotProductOfTwoSubsequences();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums1, int[] nums2, int expected) {
    assertThat(p1458.maxDotProduct(nums1, nums2)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {2, 1, -2, 5}, new int[] {3, 0, -6}, 18),
        Arguments.of(new int[] {2, 1, -2, 5}, new int[] {3, 1, -6}, 19),
        Arguments.of(new int[] {3, -2}, new int[] {2, -6, 7}, 21),
        Arguments.of(new int[] {-1, -1}, new int[] {1, 1}, -1));
  }
}
