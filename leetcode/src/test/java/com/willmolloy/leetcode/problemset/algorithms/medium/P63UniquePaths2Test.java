package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P63UniquePaths2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P63UniquePaths2Test {

  private final P63UniquePaths2 fun = new P63UniquePaths2();

  @Test
  void example1() {
    assertThat(
            fun.uniquePathsWithObstacles(
                new int[][] {
                  {0, 0, 0},
                  {0, 1, 0},
                  {0, 0, 0},
                }))
        .isEqualTo(2);
  }

  @Test
  void finishIsAnObstacle() {
    assertThat(
            fun.uniquePathsWithObstacles(
                new int[][] {
                  {0, 0},
                  {0, 1},
                }))
        .isEqualTo(0);
  }

  @Test
  void startIsAnObstacle() {
    assertThat(
            fun.uniquePathsWithObstacles(
                new int[][] {
                  {1, 0},
                  {0, 0},
                }))
        .isEqualTo(0);
  }

  @Test
  void finishBlocked() {
    assertThat(
            fun.uniquePathsWithObstacles(
                new int[][] {
                  {0, 0},
                  {1, 1},
                  {0, 0},
                }))
        .isEqualTo(0);
  }
}
