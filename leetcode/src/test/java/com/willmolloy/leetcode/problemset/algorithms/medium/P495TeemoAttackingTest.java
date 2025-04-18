package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P495TeemoAttackingTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P495TeemoAttackingTest {

  private final P495TeemoAttacking p495 = new P495TeemoAttacking();

  @Test
  void example1() {
    assertThat(p495.findPoisonedDuration(new int[] {1, 4}, 2)).isEqualTo(4);
  }

  @Test
  void example2() {
    assertThat(p495.findPoisonedDuration(new int[] {1, 2}, 2)).isEqualTo(3);
  }
}
