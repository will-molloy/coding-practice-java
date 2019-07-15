package com.wilmol.leetcode.problems.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-07-15 at 19:42. */
class P10RegularExpressionMatchingTest {

  private final P10RegularExpressionMatching function = new P10RegularExpressionMatching();

  @Test
  void example1() {
    assertThat(function.isMatch("a", "aa")).isFalse();
  }

  @Test
  void example2() {
    assertThat(function.isMatch("aa", "a*")).isTrue();
  }

  @Test
  void example3() {
    assertThat(function.isMatch("ab", ".*")).isTrue();
  }

  @Test
  void example4() {
    assertThat(function.isMatch("aab", "c*a*b")).isTrue();
  }

  @Test
  void example5() {
    assertThat(function.isMatch("mississippi", "mis*is*p*.")).isFalse();
  }
}
