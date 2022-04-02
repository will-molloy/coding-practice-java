package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1615MaximalNetworkRankTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1615MaximalNetworkRankTest {

  private final P1615MaximalNetworkRank p1615 = new P1615MaximalNetworkRank();

  @ParameterizedTest
  @MethodSource
  void examples(int n, int[][] roads, int expected) {
    assertThat(p1615.maximalNetworkRank(n, roads)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(4, new int[][] {{0, 1}, {0, 3}, {1, 2}, {1, 3}}, 4),
        Arguments.of(5, new int[][] {{0, 1}, {0, 3}, {1, 2}, {1, 3}, {2, 3}, {2, 4}}, 5),
        Arguments.of(8, new int[][] {{0, 1}, {1, 2}, {2, 3}, {2, 4}, {5, 6}, {5, 7}}, 5));
  }
}
