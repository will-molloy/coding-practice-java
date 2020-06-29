package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P409LongestPalindromeTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P409LongestPalindromeTest {

  private final P409LongestPalindrome p409 = new P409LongestPalindrome();

  @Test
  void example() {
    assertThat(p409.longestPalindrome("abccccdd")).isEqualTo(7);
  }

  @Test
  void noDupes() {
    assertThat(p409.longestPalindrome("aA")).isEqualTo(1);
  }

  @Test
  void noOddFreqs() {
    assertThat(p409.longestPalindrome("aabb")).isEqualTo(4);
  }
}
