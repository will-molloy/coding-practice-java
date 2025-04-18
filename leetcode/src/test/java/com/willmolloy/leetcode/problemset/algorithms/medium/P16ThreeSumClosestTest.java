package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P16ThreeSumClosestTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P16ThreeSumClosestTest {

  private final P16ThreeSumClosest function = new P16ThreeSumClosest();

  @Test
  void example() {
    assertThat(function.threeSumClosest(new int[] {-1, 2, 1, -4}, 1)).isEqualTo(2);
  }

  @Test
  void canSumToTarget() {
    assertThat(function.threeSumClosest(new int[] {-1, 2, 1, -4}, 2)).isEqualTo(2);
  }

  @Test
  void equalElements() {
    assertThat(function.threeSumClosest(new int[] {0, 0, 0, 0, 0}, 20)).isEqualTo(0);
  }
}
