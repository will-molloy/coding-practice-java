package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-05-18. */
class P567PermutationInStringTest {

  private final P567PermutationInString p567 = new P567PermutationInString();

  @Test
  void example1() {
    assertThat(p567.checkInclusion("ab", "eidbaooo")).isTrue();
  }

  @Test
  void example2() {
    assertThat(p567.checkInclusion("ab", "eidboaoo")).isFalse();
  }

  @Test
  void coveredByInitialWindow() {
    assertThat(p567.checkInclusion("abc", "cba")).isTrue();
  }

  @Test
  void s2Smaller() {
    assertThat(p567.checkInclusion("ab", "a")).isFalse();
  }
}
