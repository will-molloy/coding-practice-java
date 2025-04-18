package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1584MinCostToConnectAllPointsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1584MinCostToConnectAllPointsTest {

  private final P1584MinCostToConnectAllPoints p1584 = new P1584MinCostToConnectAllPoints();

  @ParameterizedTest
  @MethodSource
  void examples(int[][] points, int expected) {
    assertThat(p1584.minCostConnectPoints(points)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(
            new int[][] {
              {
                0, 0,
              },
              {2, 2},
              {3, 10},
              {5, 2},
              {7, 0}
            },
            20),
        Arguments.of(new int[][] {{3, 12}, {-2, 5}, {-4, 1}}, 18),
        Arguments.of(new int[][] {{0, 0}, {1, 1}, {1, 0}, {-1, 1}}, 4),
        Arguments.of(new int[][] {{-1000000, -1000000}, {1000000, 1000000}}, 4000000));
  }
}
