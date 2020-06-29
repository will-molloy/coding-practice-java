package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P48RotateImageTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P48RotateImageTest {

  private final P48RotateImage fun = new P48RotateImage();

  @Test
  void example1Matrix3x3() {
    int[][] a = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };
    fun.rotate(a);
    assertThat(a)
        .isEqualTo(
            new int[][] {
              {7, 4, 1},
              {8, 5, 2},
              {9, 6, 3}
            });
  }

  @Test
  void example2Matrix4x4() {
    int[][] a = {
      {5, 1, 9, 11},
      {2, 4, 8, 10},
      {13, 3, 6, 7},
      {15, 14, 12, 16}
    };
    fun.rotate(a);
    assertThat(a)
        .isEqualTo(
            new int[][] {
              {15, 13, 2, 5},
              {14, 3, 4, 1},
              {12, 6, 8, 9},
              {16, 7, 10, 11}
            });
  }

  @Test
  void matrix5x5() {
    int[][] a = {
      {1, 2, 3, 4, 5},
      {6, 7, 8, 9, 10},
      {11, 12, 13, 14, 15},
      {16, 17, 18, 19, 20},
      {21, 22, 23, 24, 25},
    };
    fun.rotate(a);
    assertThat(a)
        .isEqualTo(
            new int[][] {
              {21, 16, 11, 6, 1},
              {22, 17, 12, 7, 2},
              {23, 18, 13, 8, 3},
              {24, 19, 14, 9, 4},
              {25, 20, 15, 10, 5},
            });
  }
}
