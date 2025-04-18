package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1594MaximumNonNegativeProductInAMatrixTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1594MaximumNonNegativeProductInAMatrixTest {

  private final P1594MaximumNonNegativeProductInAMatrix p1594 =
      new P1594MaximumNonNegativeProductInAMatrix();

  @Test
  void example1() {
    assertThat(
            p1594.maxProductPath(
                new int[][] {
                  {-1, -2, -3},
                  {-2, -3, -3},
                  {-3, -3, -2},
                }))
        .isEqualTo(-1);
  }

  @Test
  void example2() {
    assertThat(
            p1594.maxProductPath(
                new int[][] {
                  {1, -2, 1},
                  {1, -2, 1},
                  {3, -4, 1},
                }))
        .isEqualTo(8);
  }

  @Test
  void example3() {
    assertThat(
            p1594.maxProductPath(
                new int[][] {
                  {1, 3},
                  {0, -4},
                }))
        .isEqualTo(0);
  }

  @Test
  void example4() {
    assertThat(
            p1594.maxProductPath(
                new int[][] {
                  {1, 4, 4, 0},
                  {-2, 0, 0, 1},
                  {1, -1, 1, 1},
                }))
        .isEqualTo(2);
  }
}
