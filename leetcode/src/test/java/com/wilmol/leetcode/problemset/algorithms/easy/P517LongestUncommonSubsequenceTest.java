package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P517LongestUncommonSubsequenceTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P517LongestUncommonSubsequenceTest {

  private final P517LongestUncommonSubsequence p517 = new P517LongestUncommonSubsequence();

  @Test
  void example1() {
    assertThat(p517.findLusLength("aba", "cdc")).isEqualTo(3);
  }

  @Test
  void example2() {
    assertThat(p517.findLusLength("aaa", "bbb")).isEqualTo(3);
  }

  @Test
  void example3() {
    assertThat(p517.findLusLength("aaa", "aaa")).isEqualTo(-1);
  }
}
