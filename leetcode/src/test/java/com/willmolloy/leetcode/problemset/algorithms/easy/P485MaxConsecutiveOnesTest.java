package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P485MaxConsecutiveOnesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P485MaxConsecutiveOnesTest {

  private final P485MaxConsecutiveOnes p485 = new P485MaxConsecutiveOnes();

  @Test
  void example1() {
    assertThat(p485.findMaxConsecutiveOnes(new int[] {1, 1, 0, 1, 1, 1})).isEqualTo(3);
  }

  @Test
  void longestAtStart() {
    assertThat(p485.findMaxConsecutiveOnes(new int[] {1, 1, 1, 1, 0, 1, 1, 1})).isEqualTo(4);
  }

  @Test
  void longestInMiddle() {
    assertThat(p485.findMaxConsecutiveOnes(new int[] {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1}))
        .isEqualTo(6);
  }
}
