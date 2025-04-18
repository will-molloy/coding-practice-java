package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P329LongestIncreasingPathInAMatrixTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P329LongestIncreasingPathInAMatrixTest {

  private final P329LongestIncreasingPathInAMatrix p329LongestIncreasingPathInAMatrix =
      new P329LongestIncreasingPathInAMatrix();

  @Test
  void example1() {
    assertThat(
            p329LongestIncreasingPathInAMatrix.longestIncreasingPath(
                new int[][] {
                  {9, 9, 4},
                  {6, 6, 8},
                  {2, 1, 1},
                }))
        .isEqualTo(4);
  }

  @Test
  void example2() {
    assertThat(
            p329LongestIncreasingPathInAMatrix.longestIncreasingPath(
                new int[][] {
                  {3, 4, 5},
                  {3, 2, 6},
                  {2, 2, 1},
                }))
        .isEqualTo(4);
  }

  @Test
  void example3() {
    assertThat(
            p329LongestIncreasingPathInAMatrix.longestIncreasingPath(
                new int[][] {
                  {1},
                }))
        .isEqualTo(1);
  }
}
