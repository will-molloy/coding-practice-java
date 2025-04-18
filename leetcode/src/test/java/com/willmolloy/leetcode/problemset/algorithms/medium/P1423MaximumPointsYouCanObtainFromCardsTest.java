package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1423MaximumPointsYouCanObtainFromCardsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1423MaximumPointsYouCanObtainFromCardsTest {

  private final P1423MaximumPointsYouCanObtainFromCards p1423 =
      new P1423MaximumPointsYouCanObtainFromCards();

  @Test
  void example1() {
    assertThat(p1423.maxScore(new int[] {1, 2, 3, 4, 5, 6, 1}, 3)).isEqualTo(12);
  }

  @Test
  void example2() {
    assertThat(p1423.maxScore(new int[] {2, 2, 2}, 2)).isEqualTo(4);
  }

  @Test
  void example3() {
    assertThat(p1423.maxScore(new int[] {9, 7, 7, 9, 7, 7, 9}, 7)).isEqualTo(55);
  }

  @Test
  void example4() {
    assertThat(p1423.maxScore(new int[] {1, 1000, 1}, 1)).isEqualTo(1);
  }

  @Test
  void example5() {
    assertThat(p1423.maxScore(new int[] {1, 79, 80, 1, 1, 1, 200, 1}, 3)).isEqualTo(202);
  }
}
