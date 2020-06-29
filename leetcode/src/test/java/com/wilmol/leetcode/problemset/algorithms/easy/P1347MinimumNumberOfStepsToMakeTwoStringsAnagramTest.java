package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1347MinimumNumberOfStepsToMakeTwoStringsAnagramTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1347MinimumNumberOfStepsToMakeTwoStringsAnagramTest {

  private final P1347MinimumNumberOfStepsToMakeTwoStringsAnagram fun =
      new P1347MinimumNumberOfStepsToMakeTwoStringsAnagram();

  @Test
  void example1() {
    assertThat(fun.minSteps("bab", "aba")).isEqualTo(1);
  }

  @Test
  void example2() {
    assertThat(fun.minSteps("leetcode", "practice")).isEqualTo(5);
  }

  @Test
  void example3() {
    assertThat(fun.minSteps("anagram", "mangaar")).isEqualTo(0);
  }

  @Test
  void example4() {
    assertThat(fun.minSteps("xxyyzz", "xxyyzz")).isEqualTo(0);
  }

  @Test
  void example5() {
    assertThat(fun.minSteps("friend", "family")).isEqualTo(4);
  }
}
