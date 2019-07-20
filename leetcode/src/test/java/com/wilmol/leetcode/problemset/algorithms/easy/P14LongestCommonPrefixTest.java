package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-07-20 at 22:07. */
class P14LongestCommonPrefixTest {

  private final P14LongestCommonPrefix function = new P14LongestCommonPrefix();

  @Test
  void example1() {
    assertThat(function.longestCommonPrefix(new String[] {"flower", "flow", "flight"}))
        .isEqualTo("fl");
  }

  @Test
  void example2() {
    assertThat(function.longestCommonPrefix(new String[] {"dog", "racecar", "car"})).isEqualTo("");
  }

  @Test
  void singleString() {
    assertThat(function.longestCommonPrefix(new String[] {"hithere"})).isEqualTo("hithere");
  }

  @Test
  void multipleEqualStrings() {
    assertThat(function.longestCommonPrefix(new String[] {"abc", "abc", "abc"})).isEqualTo("abc");
  }

  @Test
  void stringsGetLonger() {
    assertThat(function.longestCommonPrefix(new String[] {"a", "ab", "abc"})).isEqualTo("a");
  }

  @Test
  void stringsGetShorter() {
    assertThat(function.longestCommonPrefix(new String[] {"abc", "ab", "a"})).isEqualTo("a");
  }

  @Test
  void nullAndEmpty() {
    assertThat(function.longestCommonPrefix(null)).isEqualTo("");
    assertThat(function.longestCommonPrefix(new String[0])).isEqualTo("");
  }
}
