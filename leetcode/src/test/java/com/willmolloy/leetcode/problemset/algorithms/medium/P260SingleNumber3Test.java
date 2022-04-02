package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P260SingleNumber3Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P260SingleNumber3Test {

  private final P260SingleNumber3 p260 = new P260SingleNumber3();

  @Test
  void example() {
    assertThat(p260.singleNumber(new int[] {1, 2, 1, 3, 2, 5})).asList().containsExactly(3, 5);
  }
}
