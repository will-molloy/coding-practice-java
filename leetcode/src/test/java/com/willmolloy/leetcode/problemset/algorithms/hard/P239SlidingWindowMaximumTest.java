package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P239SlidingWindowMaximumTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P239SlidingWindowMaximumTest {

  private final P239SlidingWindowMaximum p239 = new P239SlidingWindowMaximum();

  @Test
  void example() {
    assertThat(p239.maxSlidingWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3))
        .asList()
        .containsExactly(3, 3, 5, 5, 6, 7)
        .inOrder();
  }
}
