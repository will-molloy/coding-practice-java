package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P832FlippingAnImageTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P832FlippingAnImageTest {

  private final P832FlippingAnImage p832 = new P832FlippingAnImage();

  @Test
  void example1() {
    assertThat(
            p832.flipAndInvertImage(
                new int[][] {
                  {1, 1, 0},
                  {1, 0, 1},
                  {0, 0, 0},
                }))
        .isEqualTo(
            new int[][] {
              {1, 0, 0}, {0, 1, 0}, {1, 1, 1},
            });
  }

  @Test
  void example2() {
    assertThat(
            p832.flipAndInvertImage(
                new int[][] {
                  {1, 1, 0, 0},
                  {1, 0, 0, 1},
                  {0, 1, 1, 1},
                  {1, 0, 1, 0},
                }))
        .isEqualTo(
            new int[][] {
              {1, 1, 0, 0},
              {0, 1, 1, 0},
              {0, 0, 0, 1},
              {1, 0, 1, 0},
            });
  }
}
