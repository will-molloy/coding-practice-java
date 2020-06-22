package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-25. */
class P345ReverseVowelsOfAStringTest {

  private final P345ReverseVowelsOfAString p345 = new P345ReverseVowelsOfAString();

  @Test
  void example1() {
    assertThat(p345.reverseVowels("hello")).isEqualTo("holle");
  }

  @Test
  void example2() {
    assertThat(p345.reverseVowels("leetcode")).isEqualTo("leotcede");
  }

  @Test
  void withSpaces() {
    assertThat(p345.reverseVowels("harry potter")).isEqualTo("herry pottar");
  }

  @Test
  void withUppercaseVowels() {
    assertThat(p345.reverseVowels("aA")).isEqualTo("Aa");
  }
}
