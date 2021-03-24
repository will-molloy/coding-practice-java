package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;
import static com.wilmol.testlib.CartesianProduct.cartesianProduct;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1696JumpGame6Test.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1696JumpGame6Test {

  @ParameterizedTest
  @MethodSource
  void examples(P1696JumpGame6 p1696JumpGame6, int[] nums, int k, int expected) {
    assertThat(p1696JumpGame6.maxResult(nums, k)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return cartesianProduct(solutions(), exampleArgs());
  }

  static Stream<Arguments> exampleArgs() {
    return Stream.of(
        Arguments.of(new int[] {1, -1, -2, 4, -7, 3}, 2, 7),
        Arguments.of(new int[] {10, -5, -2, 4, 0, 3}, 3, 17),
        Arguments.of(new int[] {1, -5, -20, 4, -1, 3, -6, -3}, 2, 0));
  }

  static Stream<P1696JumpGame6> solutions() {
    return Stream.of(new P1696JumpGame6.NaiveDp(), new P1696JumpGame6.AcceptedDp());
  }
}
