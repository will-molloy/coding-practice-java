package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P300LongestIncreasingSubsequenceTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P300LongestIncreasingSubsequenceTest {

  private final P300LongestIncreasingSubsequence fun = new P300LongestIncreasingSubsequence();

  @Test
  void example() {
    assertThat(fun.lengthOfLis(new int[] {10, 9, 2, 3, 7, 101, 18})).isEqualTo(4);
  }

  @Test
  void elementExtendsTwoIncreasingSubsequencesFormerIsLonger() {
    assertThat(fun.lengthOfLis(new int[] {1, 2, 3, 1, 2, 4})).isEqualTo(4);
  }

  @Test
  void elementExtendsTwoIncreasingSubsequencesLatterIsLonger() {
    assertThat(fun.lengthOfLis(new int[] {1, 2, 1, 2, 3, 4})).isEqualTo(4);
  }

  @Test
  void lastElementNotInLongestIncreasingSubsequence() {
    assertThat(fun.lengthOfLis(new int[] {1, 2, 3, 4, 5, 0})).isEqualTo(5);
  }

  @Test
  void ascendingArray() {
    assertThat(fun.lengthOfLis(new int[] {1, 2, 3, 4, 5, 6})).isEqualTo(6);
  }

  @Test
  void descendingArray() {
    assertThat(fun.lengthOfLis(new int[] {6, 5, 4, 3, 2, 1})).isEqualTo(1);
  }

  @Test
  void sequenceMustIncreaseNotNotDecrease() {
    assertThat(fun.lengthOfLis(new int[] {1, 1, 1, 2, 2, 2})).isEqualTo(2);
  }

  @Test
  void emptyArray() {
    assertThat(fun.lengthOfLis(new int[0])).isEqualTo(0);
  }
}
