package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P191NumberOf1BitsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P191NumberOf1BitsTest {

  private final P191NumberOf1Bits p191 = new P191NumberOf1Bits();

  @Test
  void example1() {
    assertThat(p191.hammingWeight(0b1011)).isEqualTo(3);
  }

  @Test
  void example2() {
    assertThat(p191.hammingWeight(0b10000000)).isEqualTo(1);
  }

  @Test
  void example3() {
    assertThat(p191.hammingWeight(0b11111111111111111111111111111101)).isEqualTo(31);
  }
}
