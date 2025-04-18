package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P125ValidPalindromeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P125ValidPalindromeTest {

  private final P125ValidPalindrome fun = new P125ValidPalindrome();

  @Test
  void example1() {
    assertThat(fun.isPalindrome("A man, a plan, a canal: Panama")).isTrue();
  }

  @Test
  void example2() {
    assertThat(fun.isPalindrome("race a car")).isFalse();
  }
}
