package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1579RemoveMaxNumberOfEdgesToKeepGraphFullyTraversableTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1579RemoveMaxNumberOfEdgesToKeepGraphFullyTraversableTest {

  private final P1579RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable p1579 =
      new P1579RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable();

  @Test
  void example1() {
    assertThat(
            p1579.maxNumEdgesToRemove(
                4, new int[][] {{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}}))
        .isEqualTo(2);
  }

  @Test
  void example2() {
    assertThat(
            p1579.maxNumEdgesToRemove(4, new int[][] {{3, 1, 2}, {3, 2, 3}, {1, 1, 4}, {2, 1, 4}}))
        .isEqualTo(0);
  }

  @Test
  void example3() {
    assertThat(p1579.maxNumEdgesToRemove(4, new int[][] {{3, 2, 3}, {1, 1, 2}, {2, 3, 4}}))
        .isEqualTo(-1);
  }
}
