package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-21. */
class P1143LongestCommonSubsequenceTest {
  private final P1143LongestCommonSubsequence p1143 = new P1143LongestCommonSubsequence();

  @Test
  void example1() {
    assertThat(p1143.longestCommonSubsequence("abcde", "ace")).isEqualTo(3);
  }

  @Test
  void example2() {
    assertThat(p1143.longestCommonSubsequence("abc", "abc")).isEqualTo(3);
  }

  @Test
  void example3() {
    assertThat(p1143.longestCommonSubsequence("abc", "def")).isEqualTo(0);
  }

  @Test
  void text1Empty() {
    assertThat(p1143.longestCommonSubsequence("", "def")).isEqualTo(0);
  }

  @Test
  void text2Empty() {
    assertThat(p1143.longestCommonSubsequence("abc", "")).isEqualTo(0);
  }
}
