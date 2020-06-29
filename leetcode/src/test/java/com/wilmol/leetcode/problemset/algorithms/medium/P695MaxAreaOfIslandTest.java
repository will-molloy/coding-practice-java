package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P695MaxAreaOfIslandTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P695MaxAreaOfIslandTest {

  private final P695MaxAreaOfIsland p695 = new P695MaxAreaOfIsland();

  @Test
  void example1() {
    assertThat(
            p695.maxAreaOfIsland(
                new int[][] {
                  {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                  {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                  {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                  {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                  {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                  {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                  {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
                }))
        .isEqualTo(6);
  }

  @Test
  void example2() {
    assertThat(p695.maxAreaOfIsland(new int[][] {{0, 0, 0, 0, 0, 0, 0, 0}})).isEqualTo(0);
  }
}
