package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P494TargetSumTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P494TargetSumTest {

  private final P494TargetSum p494 = new P494TargetSum();

  @Test
  void example1() {
    assertThat(p494.findTargetSumWays(new int[] {1, 1, 1, 1, 1}, 3)).isEqualTo(5);
  }
}
