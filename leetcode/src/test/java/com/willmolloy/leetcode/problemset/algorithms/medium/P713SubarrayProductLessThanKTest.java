package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P713SubarrayProductLessThanKTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P713SubarrayProductLessThanKTest {

  private final P713SubarrayProductLessThanK p713 = new P713SubarrayProductLessThanK();

  @Test
  void example() {
    assertThat(p713.numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100)).isEqualTo(8);
  }

  @Test
  void wholeArrayValid() {
    assertThat(p713.numSubarrayProductLessThanK(new int[] {1, 2, 3}, 7)).isEqualTo(6);
  }

  @Test
  void noneValid() {
    assertThat(p713.numSubarrayProductLessThanK(new int[] {1, 1, 1}, 0)).isEqualTo(0);
  }
}
