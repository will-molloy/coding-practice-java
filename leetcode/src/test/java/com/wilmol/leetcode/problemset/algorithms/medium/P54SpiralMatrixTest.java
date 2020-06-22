package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2019-11-03. */
class P54SpiralMatrixTest {

  private final P54SpiralMatrix fun = new P54SpiralMatrix();

  @Test
  void example1Matrix3x3() {
    assertThat(
            fun.spiralOrder(
                new int[][] {
                  {1, 2, 3},
                  {4, 5, 6},
                  {7, 8, 9}
                }))
        .containsExactly(1, 2, 3, 6, 9, 8, 7, 4, 5)
        .inOrder();
  }

  @Test
  void example2Matrix3x4() {
    assertThat(
            fun.spiralOrder(
                new int[][] {
                  {1, 2, 3, 4},
                  {5, 6, 7, 8},
                  {9, 10, 11, 12}
                }))
        .containsExactly(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)
        .inOrder();
  }

  @Test
  void matrix4x3() {
    assertThat(
            fun.spiralOrder(
                new int[][] {
                  {1, 2, 3},
                  {4, 5, 6},
                  {7, 8, 9},
                  {10, 11, 12}
                }))
        .containsExactly(1, 2, 3, 6, 9, 12, 11, 10, 7, 4, 5, 8)
        .inOrder();
  }

  @Test
  void matrix1x1() {
    assertThat(fun.spiralOrder(new int[][] {{1}})).containsExactly(1);
  }

  @Test
  void matrix0x0() {
    assertThat(fun.spiralOrder(new int[][] {})).isEmpty();
  }

  @Test
  void matrix2x2() {
    assertThat(
            fun.spiralOrder(
                new int[][] {
                  {1, 2},
                  {3, 4}
                }))
        .containsExactly(1, 2, 4, 3)
        .inOrder();
  }

  @Test
  void matrix1x2() {
    assertThat(fun.spiralOrder(new int[][] {{2, 3}})).containsExactly(2, 3).inOrder();
  }

  @Test
  void matrix2x1() {
    assertThat(fun.spiralOrder(new int[][] {{2}, {3}})).containsExactly(2, 3).inOrder();
  }
}
