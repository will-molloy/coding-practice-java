package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-05-27. */
class P338CountingBitsTest {

  private final P338CountingBits p338 = new P338CountingBits();

  @Test
  void example1() {
    assertThat(p338.countBits(2)).asList().containsExactly(0, 1, 1).inOrder();
  }

  @Test
  void example2() {
    assertThat(p338.countBits(5)).asList().containsExactly(0, 1, 1, 2, 1, 2).inOrder();
  }
}
