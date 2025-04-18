package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1631PathWithMinimumEffortTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1631PathWithMinimumEffortTest {

  private final P1631PathWithMinimumEffort p1631PathWithMinimumEffort =
      new P1631PathWithMinimumEffort();

  @Test
  void example1() {
    assertThat(
            p1631PathWithMinimumEffort.minimumEffortPath(
                new int[][] {
                  {1, 2, 2},
                  {3, 8, 2},
                  {5, 3, 5},
                }))
        .isEqualTo(2);
  }

  @Test
  void example2() {
    assertThat(
            p1631PathWithMinimumEffort.minimumEffortPath(
                new int[][] {
                  {1, 2, 3},
                  {3, 8, 4},
                  {5, 3, 5},
                }))
        .isEqualTo(1);
  }

  @Test
  void example3() {
    assertThat(
            p1631PathWithMinimumEffort.minimumEffortPath(
                new int[][] {
                  {1, 2, 1, 1, 1},
                  {1, 2, 1, 2, 1},
                  {1, 2, 1, 2, 1},
                  {1, 2, 1, 2, 1},
                  {1, 2, 1, 2, 1},
                  {1, 1, 1, 2, 1},
                }))
        .isEqualTo(0);
  }
}
