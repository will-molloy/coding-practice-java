package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-27. */
class P1306JumpGame3Test {

  private final P1306JumpGame3 p1306 = new P1306JumpGame3();

  @Test
  void example1() {
    assertThat(p1306.canReach(new int[] {4, 2, 3, 0, 3, 1, 2}, 5)).isTrue();
  }

  @Test
  void example2() {
    assertThat(p1306.canReach(new int[] {4, 2, 3, 0, 3, 1, 2}, 0)).isTrue();
  }

  @Test
  void example3() {
    assertThat(p1306.canReach(new int[] {3, 0, 2, 1, 2}, 2)).isFalse();
  }
}
