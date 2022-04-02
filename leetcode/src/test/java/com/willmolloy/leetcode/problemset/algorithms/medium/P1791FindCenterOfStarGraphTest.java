package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1791FindCenterOfStarGraphTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1791FindCenterOfStarGraphTest {

  private final P1791FindCenterOfStarGraph p1791FindCenterOfStarGraph =
      new P1791FindCenterOfStarGraph();

  @Test
  void example1() {
    assertThat(p1791FindCenterOfStarGraph.findCenter(new int[][] {{1, 2}, {2, 3}, {4, 2}}))
        .isEqualTo(2);
  }

  @Test
  void example2() {
    assertThat(p1791FindCenterOfStarGraph.findCenter(new int[][] {{1, 2}, {5, 1}, {1, 3}, {1, 4}}))
        .isEqualTo(1);
  }
}
