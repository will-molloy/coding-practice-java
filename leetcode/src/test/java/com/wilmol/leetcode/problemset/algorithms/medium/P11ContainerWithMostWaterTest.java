package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P11ContainerWithMostWaterTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P11ContainerWithMostWaterTest {

  private final P11ContainerWithMostWater function = new P11ContainerWithMostWater();

  @Test
  void example() {
    assertThat(function.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7})).isEqualTo(49);
  }

  @Test
  void twoEqualHeights() {
    assertThat(function.maxArea(new int[] {1, 1})).isEqualTo(1);
  }
}
