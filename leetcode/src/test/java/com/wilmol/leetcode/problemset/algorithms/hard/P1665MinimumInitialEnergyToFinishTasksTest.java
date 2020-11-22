package com.wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1665MinimumInitialEnergyToFinishTasksTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1665MinimumInitialEnergyToFinishTasksTest {

  private final P1665MinimumInitialEnergyToFinishTasks p1665 =
      new P1665MinimumInitialEnergyToFinishTasks();

  @Test
  void example1() {
    assertThat(p1665.minimumEffort(new int[][] {{1, 2}, {2, 4}, {4, 8}})).isEqualTo(8);
  }

  @Test
  void example2() {
    assertThat(p1665.minimumEffort(new int[][] {{1, 3}, {2, 4}, {10, 11}, {10, 12}, {8, 9}}))
        .isEqualTo(32);
  }

  @Test
  void example3() {
    assertThat(p1665.minimumEffort(new int[][] {{1, 7}, {2, 8}, {3, 9}, {4, 10}, {5, 11}, {6, 12}}))
        .isEqualTo(27);
  }
}
