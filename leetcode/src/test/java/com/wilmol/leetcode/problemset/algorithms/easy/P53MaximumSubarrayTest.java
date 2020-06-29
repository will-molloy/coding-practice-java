package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P53MaximumSubarrayTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P53MaximumSubarrayTest {

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
