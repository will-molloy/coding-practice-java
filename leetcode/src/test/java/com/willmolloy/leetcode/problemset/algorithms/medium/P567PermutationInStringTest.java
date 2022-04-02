package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P567PermutationInStringTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
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
