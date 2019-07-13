package com.wilmol.leetcode.problems.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-07-08 at 20:05. */
class P5LongestPalindromicSubstringTest {

  private final P5LongestPalindromicSubstring function = new P5LongestPalindromicSubstring();

  @Test
  void example1() {
    assertThat(function.longestPalindrome("babad")).isAnyOf("bab", "aba");
  }

  @Test
  void example2() {
    assertThat(function.longestPalindrome("cbbd")).isEqualTo("bb");
  }

  @Test
  void endOfString() {
    assertThat(function.longestPalindrome("banana")).isEqualTo("anana");
  }

  @Test
  void fullString() {
    assertThat(function.longestPalindrome("racecar")).isEqualTo("racecar");
  }

  @Test
  void differentLetters() {
    assertThat(function.longestPalindrome("abc")).isAnyOf("a", "b", "c");
  }

  @Test
  void emptyString() {
    assertThat(function.longestPalindrome("")).isEqualTo("");
  }
}
