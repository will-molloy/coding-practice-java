package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2019-12-15. */
class P64MinimumPathSumTest {

  static Stream<Arguments> funs() {
    return Stream.of(
        Arguments.of(new P64MinimumPathSum.RecursiveTopDown()),
        Arguments.of(new P64MinimumPathSum.DpBottomUp()));
  }

  @ParameterizedTest
  @MethodSource("funs")
  void example(P64MinimumPathSum fun) {
    assertThat(
            fun.minPathSum(
                new int[][] {
                  {1, 3, 1},
                  {1, 5, 1},
                  {4, 2, 1},
                }))
        .isEqualTo(7);
  }
}
