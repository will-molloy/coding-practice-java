package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1046LastStoneWeightTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1046LastStoneWeightTest {

  private final P1046LastStoneWeight fun = new P1046LastStoneWeight();

  @Test
  void example() {
    assertThat(fun.lastStoneWeight(new int[] {2, 7, 4, 1, 8, 1})).isEqualTo(1);
  }

  @Test
  void allDestroyed() {
    assertThat(fun.lastStoneWeight(new int[] {2, 2})).isEqualTo(0);
  }

  @Test
  void oneStone() {
    assertThat(fun.lastStoneWeight(new int[] {6})).isEqualTo(6);
  }
}
