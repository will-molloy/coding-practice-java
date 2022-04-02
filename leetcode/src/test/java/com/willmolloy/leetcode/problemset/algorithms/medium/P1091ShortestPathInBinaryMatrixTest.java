package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1091ShortestPathInBinaryMatrixTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1091ShortestPathInBinaryMatrixTest {

  private final P1091ShortestPathInBinaryMatrix p1091ShortestPathInBinaryMatrix =
      new P1091ShortestPathInBinaryMatrix();

  @Test
  void example1() {
    assertThat(
            p1091ShortestPathInBinaryMatrix.shortestPathBinaryMatrix(
                new int[][] {
                  {0, 1},
                  {1, 0},
                }))
        .isEqualTo(2);
  }

  @Test
  void example2() {
    assertThat(
            p1091ShortestPathInBinaryMatrix.shortestPathBinaryMatrix(
                new int[][] {
                  {0, 0, 0},
                  {1, 1, 0},
                  {1, 1, 0},
                }))
        .isEqualTo(4);
  }

  @Test
  void example3() {
    assertThat(
            p1091ShortestPathInBinaryMatrix.shortestPathBinaryMatrix(
                new int[][] {
                  {1, 0, 0},
                  {1, 1, 0},
                  {1, 1, 0},
                }))
        .isEqualTo(-1);
  }
}
