package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P13RomanToIntegerTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P13RomanToIntegerTest {

  private final P13RomanToInteger function = new P13RomanToInteger();

  @Test
  void example1() {
    assertThat(function.romanToInt("III")).isEqualTo(3);
  }

  @Test
  void example2() {
    assertThat(function.romanToInt("IV")).isEqualTo(4);
  }

  @Test
  void example3() {
    assertThat(function.romanToInt("IX")).isEqualTo(9);
  }

  @Test
  void example4() {
    assertThat(function.romanToInt("LVIII")).isEqualTo(58);
  }

  @Test
  void example5() {
    assertThat(function.romanToInt("MCMXCIV")).isEqualTo(1994);
  }
}
