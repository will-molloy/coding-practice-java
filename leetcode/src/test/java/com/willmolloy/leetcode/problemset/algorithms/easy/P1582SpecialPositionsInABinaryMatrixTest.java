package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1582SpecialPositionsInABinaryMatrixTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1582SpecialPositionsInABinaryMatrixTest {

  private final P1582SpecialPositionsInABinaryMatrix p1582 =
      new P1582SpecialPositionsInABinaryMatrix();

  @ParameterizedTest
  @MethodSource
  void examples(int[][] mat, int expected) {
    assertThat(p1582.numSpecial(mat)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(
            new int[][] {
              {1, 0, 0},
              {0, 0, 1},
              {1, 0, 0},
            },
            1),
        Arguments.of(
            new int[][] {
              {1, 0, 0},
              {0, 1, 0},
              {0, 0, 1},
            },
            3),
        Arguments.of(
            new int[][] {
              {0, 0, 0, 1},
              {1, 0, 0, 0},
              {0, 1, 1, 0},
              {0, 0, 0, 0}
            },
            2),
        Arguments.of(
            new int[][] {
              {0, 0, 0, 0, 0},
              {1, 0, 0, 0, 0},
              {0, 1, 0, 0, 0},
              {0, 0, 1, 0, 0},
              {0, 0, 0, 1, 1},
            },
            3));
  }
}
