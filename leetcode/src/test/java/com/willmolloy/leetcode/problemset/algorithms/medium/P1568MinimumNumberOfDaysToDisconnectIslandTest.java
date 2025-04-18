package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1568MinimumNumberOfDaysToDisconnectIslandTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1568MinimumNumberOfDaysToDisconnectIslandTest {

  private final P1568MinimumNumberOfDaysToDisconnectIsland p1568 =
      new P1568MinimumNumberOfDaysToDisconnectIsland();

  @ParameterizedTest
  @MethodSource
  void examples(int[][] grid, int expected) {
    assertThat(p1568.minDays(grid)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(
            new int[][] {
              {0, 1, 1, 0},
              {0, 1, 1, 0},
              {0, 0, 0, 0}
            },
            2),
        Arguments.of(new int[][] {{1, 1}}, 2),
        Arguments.of(new int[][] {{1, 0, 1, 0}}, 0),
        Arguments.of(
            new int[][] {
              {1, 1, 0, 1, 1},
              {1, 1, 1, 1, 1},
              {1, 1, 0, 1, 1},
              {1, 1, 0, 1, 1}
            },
            1),
        Arguments.of(
            new int[][] {
              {1, 1, 0, 1, 1},
              {1, 1, 1, 1, 1},
              {1, 1, 0, 1, 1},
              {1, 1, 1, 1, 1}
            },
            2));
  }
}
