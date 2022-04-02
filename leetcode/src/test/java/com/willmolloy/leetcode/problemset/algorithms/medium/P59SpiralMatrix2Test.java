package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * P59SpiralMatrix2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P59SpiralMatrix2Test {

  private final P59SpiralMatrix2 fun = new P59SpiralMatrix2();

  @Test
  void negativeN() {
    assertThrows(IllegalArgumentException.class, () -> fun.generateMatrix(-1));
  }

  @Test
  void nOf0() {
    assertThat(fun.generateMatrix(0)).isEmpty();
  }

  @Test
  void nOf1() {
    assertThat(fun.generateMatrix(1)).isEqualTo(new int[][] {{1}});
  }

  @Test
  void nOf2() {
    assertThat(fun.generateMatrix(2))
        .isEqualTo(
            new int[][] {
              {1, 2},
              {4, 3}
            });
  }

  @Test
  void nOf3() {
    assertThat(fun.generateMatrix(3))
        .isEqualTo(
            new int[][] {
              {1, 2, 3},
              {8, 9, 4},
              {7, 6, 5}
            });
  }

  @Test
  void nOf4() {
    assertThat(fun.generateMatrix(4))
        .isEqualTo(
            new int[][] {
              {1, 2, 3, 4},
              {12, 13, 14, 5},
              {11, 16, 15, 6},
              {10, 9, 8, 7}
            });
  }

  @Test
  void nOf5() {
    assertThat(fun.generateMatrix(5))
        .isEqualTo(
            new int[][] {
              {1, 2, 3, 4, 5},
              {16, 17, 18, 19, 6},
              {15, 24, 25, 20, 7},
              {14, 23, 22, 21, 8},
              {13, 12, 11, 10, 9},
            });
  }
}
