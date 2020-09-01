package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P949LargestTimeForGivenDigitsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P949LargestTimeForGivenDigitsTest {

  private final P949LargestTimeForGivenDigits p949 = new P949LargestTimeForGivenDigits();

  @Test
  void example1() {
    assertThat(p949.largestTimeFromDigits(new int[] {1, 2, 3, 4})).isEqualTo("23:41");
  }

  @Test
  void example2() {
    assertThat(p949.largestTimeFromDigits(new int[] {5, 5, 5, 5})).isEmpty();
  }
}
