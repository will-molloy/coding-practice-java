package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P746MinCostClimbingStairsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P746MinCostClimbingStairsTest {

  @ParameterizedTest
  @MethodSource("funs")
  void example1(P746MinCostClimbingStairs fun) {
    assertThat(fun.minCostClimbingStairs(new int[] {10, 15, 20})).isEqualTo(15);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void example2(P746MinCostClimbingStairs fun) {
    assertThat(fun.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}))
        .isEqualTo(6);
  }

  static Stream<Arguments> funs() {
    return Stream.of(
        Arguments.of(new P746MinCostClimbingStairs.Recursive()),
        Arguments.of(new P746MinCostClimbingStairs.Dp()));
  }
}
