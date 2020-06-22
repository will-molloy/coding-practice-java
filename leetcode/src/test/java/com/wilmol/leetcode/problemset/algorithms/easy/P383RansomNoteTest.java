package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-05-03. */
class P383RansomNoteTest {

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
