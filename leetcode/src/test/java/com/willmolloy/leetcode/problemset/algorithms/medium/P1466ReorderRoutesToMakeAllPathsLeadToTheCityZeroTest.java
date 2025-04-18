package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1466ReorderRoutesToMakeAllPathsLeadToTheCityZeroTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1466ReorderRoutesToMakeAllPathsLeadToTheCityZeroTest {

  private final P1466ReorderRoutesToMakeAllPathsLeadToTheCityZero p1466 =
      new P1466ReorderRoutesToMakeAllPathsLeadToTheCityZero();

  @ParameterizedTest
  @MethodSource
  void examples(int n, int[][] connections, int expected) {
    assertThat(p1466.minReorder(n, connections)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(6, new int[][] {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}, 3),
        Arguments.of(5, new int[][] {{1, 0}, {1, 2}, {3, 2}, {3, 4}}, 2),
        Arguments.of(3, new int[][] {{1, 0}, {2, 0}}, 0));
  }
}
