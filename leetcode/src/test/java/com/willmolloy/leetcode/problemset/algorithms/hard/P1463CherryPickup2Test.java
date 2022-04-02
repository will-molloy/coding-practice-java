package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1463CherryPickup2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1463CherryPickup2Test {

  private final P1463CherryPickup2 p1463CherryPickup2 = new P1463CherryPickup2();

  @ParameterizedTest
  @MethodSource
  void examples(int[][] grid, int expected) {
    assertThat(p1463CherryPickup2.cherryPickup(grid)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(
            new int[][] {
              {3, 1, 1},
              {2, 5, 1},
              {1, 5, 5},
              {2, 1, 1},
            },
            24),
        Arguments.of(
            new int[][] {
              {1, 0, 0, 0, 0, 0, 1},
              {2, 0, 0, 0, 0, 3, 0},
              {2, 0, 9, 0, 0, 0, 0},
              {0, 3, 0, 5, 4, 0, 0},
              {1, 0, 2, 3, 0, 0, 6},
            },
            28),
        Arguments.of(
            new int[][] {
              {1, 0, 0, 3},
              {0, 0, 0, 3},
              {0, 0, 3, 3},
              {9, 0, 3, 3},
            },
            22),
        Arguments.of(
            new int[][] {
              {1, 1},
              {1, 1},
            },
            4));
  }
}
