package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P5LongestPalindromicSubstringTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
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
    assertThat(function.longestPalindrome("")).isEmpty();
  }
}
