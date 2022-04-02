package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1TwoSumTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1TwoSumTest {

  private static final int[] EMPTY = {};

  private final P1TwoSum function = new P1TwoSum();

  @Test
  void hasSolutions() {
    assertThat(function.solve(new int[] {2, 7, 11, 15}, 9)).isEqualTo(new int[] {0, 1});
    assertThat(function.solve(new int[] {1, 2, 3, 4, 5, 6}, 7)).isEqualTo(new int[] {2, 3});
    assertThat(function.solve(new int[] {3, 2, 1, 0, -1, -2, -3}, -5)).isEqualTo(new int[] {5, 6});
  }

  @Test
  void hasNoSolution() {
    assertThat(function.solve(new int[] {1, 2, 3, 4, 5, 6}, 80)).isEqualTo(EMPTY);
  }
}
