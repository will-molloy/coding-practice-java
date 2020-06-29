package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P338CountingBitsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
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
