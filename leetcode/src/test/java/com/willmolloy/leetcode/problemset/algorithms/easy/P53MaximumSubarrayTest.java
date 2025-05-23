package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P53MaximumSubarrayTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P53MaximumSubarrayTest {

  @Test
  void example() {
    assertThat(new P53MaximumSubarray().maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}))
        .isEqualTo(6);
  }

  @Test
  void allNegatives() {
    assertThat(new P53MaximumSubarray().maxSubArray(new int[] {-2, -3, -1, -5})).isEqualTo(-1);
  }
}
