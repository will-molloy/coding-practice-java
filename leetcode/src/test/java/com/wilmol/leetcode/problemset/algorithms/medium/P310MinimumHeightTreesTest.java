package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P310MinimumHeightTreesTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P310MinimumHeightTreesTest {

  private final P310MinimumHeightTrees p310 = new P310MinimumHeightTrees();

  @Test
  void example1() {
    assertThat(p310.findMinHeightTrees(4, new int[][] {{1, 0}, {1, 2}, {1, 3}})).containsExactly(1);
  }

  @Test
  void example2() {
    assertThat(p310.findMinHeightTrees(6, new int[][] {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}))
        .containsExactly(3, 4);
  }

  @Test
  void example3() {
    assertThat(p310.findMinHeightTrees(1, new int[][] {})).containsExactly(0);
  }

  @Test
  void example4() {
    assertThat(p310.findMinHeightTrees(2, new int[][] {{0, 1}})).containsExactly(0, 1);
  }
}
