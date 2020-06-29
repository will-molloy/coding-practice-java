package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P415AddStringsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P415AddStringsTest {

  private final P415AddStrings p415 = new P415AddStrings();

  @Test
  void addDigits() {
    assertThat(p415.addStrings("1", "1")).isEqualTo("2");
  }

  @Test
  void addDigitsWithCarry() {
    assertThat(p415.addStrings("1", "9")).isEqualTo("10");
  }

  @Test
  void addSeveralDigits() {
    assertThat(p415.addStrings("123", "123")).isEqualTo("246");
  }

  @Test
  void addSeveralDigitsWithCarry() {
    assertThat(p415.addStrings("9999", "9999")).isEqualTo("19998");
  }

  @Test
  void addNumbersOfDifferentLength() {
    assertThat(p415.addStrings("9999", "0")).isEqualTo("9999");
  }

  @Test
  void addNumbersOfDifferentLengthWithCarry() {
    assertThat(p415.addStrings("9999", "1")).isEqualTo("10000");
  }
}
