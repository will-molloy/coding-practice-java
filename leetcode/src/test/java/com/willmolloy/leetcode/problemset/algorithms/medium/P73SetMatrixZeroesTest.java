package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P73SetMatrixZeroesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P73SetMatrixZeroesTest {

  private final P73SetMatrixZeroes fun = new P73SetMatrixZeroes();

  @Test
  void example1() {
    int[][] matrix = {
      {1, 1, 1},
      {1, 0, 1},
      {1, 1, 1},
    };
    fun.setZeroes(matrix);
    assertThat(matrix)
        .isEqualTo(
            new int[][] {
              {1, 0, 1},
              {0, 0, 0},
              {1, 0, 1},
            });
  }

  @Test
  void example2() {
    int[][] matrix = {
      {0, 1, 2, 0},
      {3, 4, 5, 2},
      {1, 3, 1, 5},
    };
    fun.setZeroes(matrix);
    assertThat(matrix)
        .isEqualTo(
            new int[][] {
              {0, 0, 0, 0},
              {0, 4, 5, 0},
              {0, 3, 1, 0},
            });
  }
}
