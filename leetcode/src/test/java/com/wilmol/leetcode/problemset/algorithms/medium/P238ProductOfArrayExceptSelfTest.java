package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-15. */
class P238ProductOfArrayExceptSelfTest {

  private final P238ProductOfArrayExceptSelf fun = new P238ProductOfArrayExceptSelf();

  @Test
  void example() {
    assertThat(fun.productExceptSelf(new int[] {1, 2, 3, 4}))
        .asList()
        .containsExactly(24, 12, 8, 6)
        .inOrder();
  }
}
