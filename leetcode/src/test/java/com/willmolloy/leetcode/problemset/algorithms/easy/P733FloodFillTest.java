package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P733FloodFillTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P733FloodFillTest {

  private final P733FloodFill p733 = new P733FloodFill();

  @Test
  void example1() {
    assertThat(
            p733.floodFill(
                new int[][] {
                  {1, 1, 1},
                  {1, 1, 0},
                  {1, 0, 1},
                },
                1,
                1,
                2))
        .isEqualTo(
            new int[][] {
              {2, 2, 2},
              {2, 2, 0},
              {2, 0, 1},
            });
  }

  @Test
  void newColorIsSame() {
    assertThat(
            p733.floodFill(
                new int[][] {
                  {1, 1, 1},
                  {1, 1, 0},
                  {1, 0, 1},
                },
                1,
                1,
                1))
        .isEqualTo(
            new int[][] {
              {1, 1, 1},
              {1, 1, 0},
              {1, 0, 1},
            });
  }
}
