package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-02-23. */
class P125ValidPalindromeTest {

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
