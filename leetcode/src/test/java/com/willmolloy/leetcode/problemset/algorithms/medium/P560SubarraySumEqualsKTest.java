package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P560SubarraySumEqualsKTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P560SubarraySumEqualsKTest {

  private final P560SubarraySumEqualsK fun = new P560SubarraySumEqualsK();

  @Test
  void example() {
    assertThat(fun.subarraySum(new int[] {1, 1, 1}, 2)).isEqualTo(2);
  }

  @Test
  void elementCompletesMultipleSequences() {
    assertThat(fun.subarraySum(new int[] {0, 1, 2, 3}, 6)).isEqualTo(2);
  }

  @Test
  void subsequenceMustBeContiguous() {
    assertThat(fun.subarraySum(new int[] {1, 2, -1, 1, 2, 3}, 6)).isEqualTo(1);
  }
}
