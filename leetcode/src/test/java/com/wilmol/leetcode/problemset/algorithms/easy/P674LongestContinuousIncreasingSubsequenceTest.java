package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P674LongestContinuousIncreasingSubsequenceTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P674LongestContinuousIncreasingSubsequenceTest {

  private final P674LongestContinuousIncreasingSubsequence fun =
      new P674LongestContinuousIncreasingSubsequence();

  @Test
  void example1() {
    assertThat(fun.findLengthOfLcis(new int[] {1, 3, 5, 4, 7})).isEqualTo(3);
  }

  @Test
  void example2() {
    assertThat(fun.findLengthOfLcis(new int[] {2, 2, 2, 2, 2})).isEqualTo(1);
  }

  @Test
  void emptyArray() {
    assertThat(fun.findLengthOfLcis(new int[0])).isEqualTo(0);
  }
}
