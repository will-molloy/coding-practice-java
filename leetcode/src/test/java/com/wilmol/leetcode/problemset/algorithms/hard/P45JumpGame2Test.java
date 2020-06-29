package com.wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P45JumpGame2Test.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P45JumpGame2Test {

  private final P45JumpGame2 p45 = new P45JumpGame2();

  @Test
  void example() {
    assertThat(p45.jump(new int[] {2, 3, 1, 1, 4})).isEqualTo(2);
  }

  @Test
  void singleElement() {
    assertThat(p45.jump(new int[] {1})).isEqualTo(0);
  }

  @Test
  void emptyArray() {
    assertThat(p45.jump(new int[0])).isEqualTo(0);
  }
}
