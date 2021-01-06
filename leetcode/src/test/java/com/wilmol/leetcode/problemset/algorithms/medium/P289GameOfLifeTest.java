package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P289GameOfLifeTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P289GameOfLifeTest {

  private final P289GameOfLife p289GameOfLife = new P289GameOfLife();

  @ParameterizedTest
  @MethodSource
  void examples(int[][] board, int[][] expected) {
    p289GameOfLife.gameOfLife(board);
    assertThat(Arrays.deepEquals(board, expected)).isTrue();
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(
            new int[][] {
              {0, 1, 0},
              {0, 0, 1},
              {1, 1, 1},
              {0, 0, 0},
            },
            new int[][] {
              {0, 0, 0},
              {1, 0, 1},
              {0, 1, 1},
              {0, 1, 0},
            }),
        Arguments.of(
            new int[][] {
              {1, 1},
              {1, 0},
            },
            new int[][] {
              {1, 1},
              {1, 1},
            }));
  }
}
