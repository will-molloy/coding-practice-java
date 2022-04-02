package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P454FourSum2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P454FourSum2Test {

  private final P454FourSum2 p454FourSum2 = new P454FourSum2();

  @Test
  void example() {
    assertThat(
            p454FourSum2.fourSumCount(
                new int[] {1, 2}, new int[] {-2, -1}, new int[] {-1, 2}, new int[] {0, 2}))
        .isEqualTo(2);
  }
}
