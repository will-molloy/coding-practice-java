package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1329SortTheMatrixDiagonallyTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1329SortTheMatrixDiagonallyTest {

  private final P1329SortTheMatrixDiagonally p1329SortTheMatrixDiagonally =
      new P1329SortTheMatrixDiagonally();

  @Test
  void example1() {
    assertThat(
            p1329SortTheMatrixDiagonally.diagonalSort(
                new int[][] {
                  {3, 3, 1, 1},
                  {2, 2, 1, 2},
                  {1, 1, 1, 2},
                }))
        .isEqualTo(
            new int[][] {
              {1, 1, 1, 1},
              {1, 2, 2, 2},
              {1, 2, 3, 3},
            });
  }

  @Test
  void example2() {
    assertThat(
            p1329SortTheMatrixDiagonally.diagonalSort(
                new int[][] {
                  {11, 25, 66, 1, 69, 7},
                  {23, 55, 17, 45, 15, 52},
                  {75, 31, 36, 44, 58, 8},
                  {22, 27, 33, 25, 68, 4},
                  {84, 28, 14, 11, 5, 50}
                }))
        .isEqualTo(
            new int[][] {
              {5, 17, 4, 1, 52, 7},
              {11, 11, 25, 45, 8, 69},
              {14, 23, 25, 44, 58, 15},
              {22, 27, 31, 36, 50, 66},
              {84, 28, 75, 33, 55, 68}
            });
  }
}
