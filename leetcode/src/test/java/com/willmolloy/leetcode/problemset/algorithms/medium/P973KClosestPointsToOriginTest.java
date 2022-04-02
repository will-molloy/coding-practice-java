package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P973KClosestPointsToOriginTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P973KClosestPointsToOriginTest {

  private final P973KClosestPointsToOrigin p973 = new P973KClosestPointsToOrigin();

  @Test
  void example1() {
    assertThat(p973.kClosest(new int[][] {{1, 3}, {-2, 2}}, 1)).isEqualTo(new int[][] {{-2, 2}});
  }

  @Test
  void example2() {
    assertThat(p973.kClosest(new int[][] {{3, 3}, {5, -1}, {-2, 4}}, 2))
        .isEqualTo(new int[][] {{-2, 4}, {3, 3}});
  }
}
