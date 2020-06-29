package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P8StringToIntegerAtoiTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P8StringToIntegerAtoiTest {

  private final P8StringToIntegerAtoi function = new P8StringToIntegerAtoi();

  @Test
  void example1Positive() {
    assertThat(function.myAtoi("42")).isEqualTo(42);
    assertThat(function.myAtoi("+42")).isEqualTo(42);
  }

  @Test
  void example2NegativeWithWhiteSpace() {
    assertThat(function.myAtoi("   -42")).isEqualTo(-42);
  }

  @Test
  void example3PositiveWithTrailingWords() {
    assertThat(function.myAtoi("4193 with words")).isEqualTo(4193);
  }

  @Test
  void example4InvalidLeadingWords() {
    assertThat(function.myAtoi("words and 987")).isEqualTo(0);
  }

  @Test
  void example5Overflow() {
    //    assertThat(function.myAtoi("-6147483648")).isEqualTo(Integer.MIN_VALUE);
    //    assertThat(function.myAtoi("-91283472332")).isEqualTo(Integer.MIN_VALUE);
    //    assertThat(function.myAtoi("91283472332")).isEqualTo(Integer.MAX_VALUE);
    assertThat(function.myAtoi("20000000000000000000")).isEqualTo(Integer.MAX_VALUE);
  }

  @Test
  void decimalPoint() {
    assertThat(function.myAtoi("3.14159")).isEqualTo(3);
  }

  @Test
  void leadingZeros() {
    assertThat(function.myAtoi("  0000000000012345678")).isEqualTo(12345678);
  }

  @Test
  void leadingZerosAndPlusSign() {
    assertThat(function.myAtoi("     +004500")).isEqualTo(4500);
  }

  @Test
  void invalidPlusMinus() {
    assertThat(function.myAtoi("+-2")).isEqualTo(0);
  }

  @Test
  void numbersAfterLettersMustBeIgnored() {
    assertThat(function.myAtoi("  -0012a42")).isEqualTo(-12);
  }
}
