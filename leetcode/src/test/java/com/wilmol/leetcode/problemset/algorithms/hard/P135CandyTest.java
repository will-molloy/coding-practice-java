package com.wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P135CandyTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P135CandyTest {

  @Test
  void example1() {
    assertThat(new P135Candy().candy(new int[] {1, 0, 2})).isEqualTo(5);
  }

  @Test
  void example2() {
    assertThat(new P135Candy().candy(new int[] {1, 2, 2})).isEqualTo(4);
  }
}
