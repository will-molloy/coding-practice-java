package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P383RansomNoteTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P383RansomNoteTest {

  private final P383RansomNote p383 = new P383RansomNote();

  @Test
  void example1() {
    assertThat(p383.canConstruct("a", "b")).isFalse();
  }

  @Test
  void example2() {
    assertThat(p383.canConstruct("aa", "ab")).isFalse();
  }

  @Test
  void example3() {
    assertThat(p383.canConstruct("aa", "aab")).isTrue();
  }
}
