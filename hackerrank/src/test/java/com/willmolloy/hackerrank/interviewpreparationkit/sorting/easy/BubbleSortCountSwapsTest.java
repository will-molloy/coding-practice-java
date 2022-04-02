package com.willmolloy.hackerrank.interviewpreparationkit.sorting.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * BubbleSortCountSwapsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class BubbleSortCountSwapsTest {

  @Test
  void noSwapsAlreadySorted() {
    assertThat(BubbleSortCountSwaps.countSwaps(new int[] {1, 2, 3})).isEqualTo(0);
  }

  @Test
  void threeSwapsReverseOrder() {
    assertThat(BubbleSortCountSwaps.countSwaps(new int[] {3, 2, 1})).isEqualTo(3);
  }

  @Test
  void sevenSwapsMustBubbleUpElements() {
    assertThat(BubbleSortCountSwaps.countSwaps(new int[] {4, 3, 5, 1, 2})).isEqualTo(7);
  }
}
