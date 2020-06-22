package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-05-30. */
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
