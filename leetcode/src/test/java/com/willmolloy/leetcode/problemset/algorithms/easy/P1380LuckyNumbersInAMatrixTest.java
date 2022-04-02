package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1380LuckyNumbersInAMatrixTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1380LuckyNumbersInAMatrixTest {

  private final P1380LuckyNumbersInAMatrix p1380LuckyNumbersInAMatrix =
      new P1380LuckyNumbersInAMatrix();

  @Test
  void example1() {
    assertThat(
            p1380LuckyNumbersInAMatrix.luckyNumbers(
                new int[][] {
                  {3, 7, 8},
                  {9, 11, 13},
                  {15, 16, 17},
                }))
        .containsExactly(15);
  }

  @Test
  void example2() {
    assertThat(
            p1380LuckyNumbersInAMatrix.luckyNumbers(
                new int[][] {
                  {1, 10, 4, 2},
                  {9, 3, 8, 7},
                  {15, 16, 17, 12},
                }))
        .containsExactly(12);
  }

  @Test
  void example3() {
    assertThat(
            p1380LuckyNumbersInAMatrix.luckyNumbers(
                new int[][] {
                  {7, 8},
                  {1, 2},
                }))
        .containsExactly(7);
  }
}
