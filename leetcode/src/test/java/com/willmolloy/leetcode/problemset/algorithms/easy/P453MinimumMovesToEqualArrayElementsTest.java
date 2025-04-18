package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P453MinimumMovesToEqualArrayElementsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P453MinimumMovesToEqualArrayElementsTest {

  private final P453MinimumMovesToEqualArrayElements p453 =
      new P453MinimumMovesToEqualArrayElements();

  @Test
  void example() {
    assertThat(p453.minMoves(new int[] {1, 2, 3})).isEqualTo(3);
  }

  @Test
  void largeDifference() {
    assertThat(p453.minMoves(new int[] {1, Integer.MAX_VALUE})).isEqualTo(Integer.MAX_VALUE - 1);
  }
}
