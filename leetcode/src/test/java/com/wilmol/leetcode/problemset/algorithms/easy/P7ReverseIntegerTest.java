package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P7ReverseIntegerTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P7ReverseIntegerTest {

  private final P7ReverseInteger function = new P7ReverseInteger();

  @Test
  void example1Positive() {
    assertThat(function.reverse(123)).isEqualTo(321);
  }

  @Test
  void example2Negative() {
    assertThat(function.reverse(-123)).isEqualTo(-321);
  }

  @Test
  void example3LeadingZero() {
    assertThat(function.reverse(120)).isEqualTo(21);
    assertThat(function.reverse(2_000_000_000)).isEqualTo(2);
  }

  @Test
  void overflow() {
    assertThat(function.reverse(Integer.MAX_VALUE)).isEqualTo(0);
    assertThat(function.reverse(Integer.MIN_VALUE)).isEqualTo(0);
    assertThat(function.reverse(1_000_000_003)).isEqualTo(0);
  }
}
