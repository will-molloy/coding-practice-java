package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1337TheKWeakestRowsInAMatrixTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1337TheKWeakestRowsInAMatrixTest {

  private final P1337TheKWeakestRowsInAMatrix p1337TheKWeakestRowsInAMatrix =
      new P1337TheKWeakestRowsInAMatrix();

  @Test
  void example1() {
    assertThat(
            p1337TheKWeakestRowsInAMatrix.kWeakestRows(
                new int[][] {
                  {1, 1, 0, 0, 0},
                  {1, 1, 1, 1, 0},
                  {1, 0, 0, 0, 0},
                  {1, 1, 0, 0, 0},
                  {1, 1, 1, 1, 1},
                },
                3))
        .asList()
        .containsExactly(2, 0, 3)
        .inOrder();
  }

  @Test
  void example2() {
    assertThat(
            p1337TheKWeakestRowsInAMatrix.kWeakestRows(
                new int[][] {
                  {1, 0, 0, 0},
                  {1, 1, 1, 1},
                  {1, 0, 0, 0},
                  {1, 0, 0, 0},
                },
                2))
        .asList()
        .containsExactly(0, 2)
        .inOrder();
  }
}
