package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P74SearchA2dMatrixTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P74SearchA2dMatrixTest {

  private final P74SearchA2dMatrix fun = new P74SearchA2dMatrix();

  @Test
  void example1() {
    assertThat(
            fun.searchMatrix(
                new int[][] {
                  {1, 3, 5, 7},
                  {10, 11, 16, 20},
                  {23, 30, 34, 50},
                },
                3))
        .isTrue();
  }

  @Test
  void example2() {
    assertThat(
            fun.searchMatrix(
                new int[][] {
                  {1, 3, 5, 7},
                  {10, 11, 16, 20},
                  {23, 30, 34, 50},
                },
                13))
        .isFalse();
  }

  @Test
  void emptyMatrix() {
    assertThat(fun.searchMatrix(new int[][] {}, 123)).isFalse();
  }
}
