package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-05-13. */
class P402RemoveKDigitsTest {

  private final P402RemoveKDigits p402 = new P402RemoveKDigits();

  @Test
  void example1() {
    assertThat(p402.removeKdigits("1432219", 3)).isEqualTo("1219");
  }

  @Test
  void example2LeadingZeros() {
    assertThat(p402.removeKdigits("10200", 1)).isEqualTo("200");
  }

  @Test
  void example3RemoveAllDigits() {
    assertThat(p402.removeKdigits("10", 2)).isEqualTo("0");
  }

  @Test
  void onlyRemoveLast() {
    assertThat(p402.removeKdigits("112", 1)).isEqualTo("11");
  }

  @Test
  void onlyRemoveFirst() {
    assertThat(p402.removeKdigits("211", 1)).isEqualTo("11");
  }

  @Test
  void onlyKeepLast() {
    assertThat(p402.removeKdigits("1234567890", 9)).isEqualTo("0");
  }

  @Test
  void onlyKeepFirst() {
    assertThat(p402.removeKdigits("0123456789", 9)).isEqualTo("0");
  }

  @Test
  void sameDigits() {
    assertThat(p402.removeKdigits("111111111", 3)).isEqualTo("111111");
  }
}
