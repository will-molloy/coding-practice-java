package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P547FriendCirclesTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P547FriendCirclesTest {

  private final P547FriendCircles p547 = new P547FriendCircles();

  @Test
  void example1() {
    assertThat(
            p547.findCircleNum(
                new int[][] {
                  {1, 1, 0},
                  {1, 1, 0},
                  {0, 0, 1}
                }))
        .isEqualTo(2);
  }

  @Test
  void example2() {
    assertThat(
            p547.findCircleNum(
                new int[][] {
                  {1, 1, 0},
                  {1, 1, 1},
                  {0, 1, 1}
                }))
        .isEqualTo(1);
  }
}
