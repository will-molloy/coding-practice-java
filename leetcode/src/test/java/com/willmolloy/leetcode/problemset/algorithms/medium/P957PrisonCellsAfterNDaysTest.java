package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P957PrisonCellsAfterNDaysTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P957PrisonCellsAfterNDaysTest {

  private final P957PrisonCellsAfterNDays p957 = new P957PrisonCellsAfterNDays();

  @Test
  void example1DoesntRepeat() {
    assertThat(p957.prisonAfterNDays(new int[] {0, 1, 0, 1, 1, 0, 0, 1}, 7))
        .asList()
        .containsExactly(0, 0, 1, 1, 0, 0, 0, 0)
        .inOrder();
  }

  @Test
  void example2MaxNRepeats() {
    assertThat(p957.prisonAfterNDays(new int[] {1, 0, 0, 1, 0, 0, 1, 0}, (int) 1e9))
        .asList()
        .containsExactly(0, 0, 1, 1, 1, 1, 1, 0)
        .inOrder();
  }

  @Test
  void repeatsOnMultipleOfN() {
    assertThat(p957.prisonAfterNDays(new int[] {1, 1, 0, 1, 1, 0, 1, 1}, 6))
        .asList()
        .containsExactly(0, 0, 1, 0, 0, 1, 0, 0)
        .inOrder();
  }

  @Test
  void repeatsOnN() {
    assertThat(p957.prisonAfterNDays(new int[] {1, 1, 0, 1, 1, 0, 1, 1}, 2))
        .asList()
        .containsExactly(0, 0, 1, 0, 0, 1, 0, 0)
        .inOrder();
  }

  @Test
  void oneIteration() {
    assertThat(p957.prisonAfterNDays(new int[] {1, 1, 0, 1, 1, 0, 1, 1}, 1))
        .asList()
        .containsExactly(0, 0, 1, 0, 0, 1, 0, 0)
        .inOrder();
  }
}
