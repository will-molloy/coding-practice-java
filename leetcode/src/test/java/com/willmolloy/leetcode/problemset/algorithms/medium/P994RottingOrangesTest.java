package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P994RottingOrangesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P994RottingOrangesTest {

  private final P994RottingOranges p994 = new P994RottingOranges();

  @Test
  void example1AllRot() {
    assertThat(
            p994.orangesRotting(
                new int[][] {
                  {2, 1, 1},
                  {1, 1, 0},
                  {0, 1, 1},
                }))
        .isEqualTo(4);
  }

  @Test
  void example2CantRotAll() {
    assertThat(
            p994.orangesRotting(
                new int[][] {
                  {2, 1, 1},
                  {1, 1, 0},
                  {1, 0, 1},
                }))
        .isEqualTo(-1);
  }

  @Test
  void example3AlreadyRotting() {
    assertThat(
            p994.orangesRotting(
                new int[][] {
                  {0, 2},
                }))
        .isEqualTo(0);
  }
}
