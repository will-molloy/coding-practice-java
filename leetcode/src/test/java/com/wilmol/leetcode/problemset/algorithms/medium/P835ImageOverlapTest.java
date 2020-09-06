package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P835ImageOverlapTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P835ImageOverlapTest {

  private final P835ImageOverlap p835 = new P835ImageOverlap();

  @Test
  void example() {
    assertThat(
            p835.largestOverlap(
                new int[][] {
                  {1, 1, 0},
                  {0, 1, 0},
                  {0, 1, 0}
                },
                new int[][] {
                  {0, 0, 0},
                  {0, 1, 1},
                  {0, 0, 1}
                }))
        .isEqualTo(3);
  }
}
