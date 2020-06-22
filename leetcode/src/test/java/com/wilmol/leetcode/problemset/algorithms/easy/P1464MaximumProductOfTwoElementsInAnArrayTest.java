package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2020-05-31. */
class P1464MaximumProductOfTwoElementsInAnArrayTest {

  private final P1464MaximumProductOfTwoElementsInAnArray p1464 =
      new P1464MaximumProductOfTwoElementsInAnArray();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int expected) {
    assertThat(p1464.maxProduct(nums)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {3, 4, 5, 2}, 12),
        Arguments.of(new int[] {1, 5, 4, 5}, 16),
        Arguments.of(new int[] {3, 7}, 12));
  }
}
