package com.wilmol.leetcode.problems.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-07-15 at 20:59. */
class P12IntegerToRomanTest {

  private final P12IntegerToRoman function = new P12IntegerToRoman();

  @Test
  void example1() {
    assertThat(function.intToRoman(3)).isEqualTo("III");
  }

  @Test
  void example2() {
    assertThat(function.intToRoman(4)).isEqualTo("IV");
  }

  @Test
  void example3() {
    assertThat(function.intToRoman(9)).isEqualTo("IX");
  }

  @Test
  void example4() {
    assertThat(function.intToRoman(58)).isEqualTo("LVIII");
  }

  @Test
  void example5() {
    assertThat(function.intToRoman(1994)).isEqualTo("MCMXCIV");
  }
}
