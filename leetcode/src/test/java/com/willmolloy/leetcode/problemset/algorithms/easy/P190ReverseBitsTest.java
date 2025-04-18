package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P190ReverseBitsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P190ReverseBitsTest {

  private final P190ReverseBits p190 = new P190ReverseBits();

  @Test
  void example1() {
    assertThat(p190.reverseBits(43261596)).isEqualTo(964176192);
  }

  @Test
  void example2OverflowedInt() {
    assertThat(p190.reverseBits(-3)).isEqualTo(-1073741825);
  }
}
