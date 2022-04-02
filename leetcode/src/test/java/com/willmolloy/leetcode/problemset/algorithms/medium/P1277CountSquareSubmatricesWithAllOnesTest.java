package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1277CountSquareSubmatricesWithAllOnesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1277CountSquareSubmatricesWithAllOnesTest {

  private final P1277CountSquareSubmatricesWithAllOnes p1277 =
      new P1277CountSquareSubmatricesWithAllOnes();

  @Test
  void example1() {
    assertThat(
            p1277.countSquares(
                new int[][] {
                  {0, 1, 1, 1},
                  {1, 1, 1, 1},
                  {0, 1, 1, 1},
                }))
        .isEqualTo(15);
  }

  @Test
  void example2() {
    assertThat(
            p1277.countSquares(
                new int[][] {
                  {1, 0, 1},
                  {1, 1, 0},
                  {1, 1, 0},
                }))
        .isEqualTo(7);
  }
}
