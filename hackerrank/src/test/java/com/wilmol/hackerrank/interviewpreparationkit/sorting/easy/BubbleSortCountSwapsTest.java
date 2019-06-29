package com.wilmol.hackerrank.interviewpreparationkit.sorting.easy;

import static com.google.common.truth.Truth.assertThat;
import static com.wilmol.hackerrank.interviewpreparationkit.sorting.easy.BubbleSortCountSwaps.countSwaps;

import org.junit.jupiter.api.Test;

class BubbleSortCountSwapsTest {

  @Test
  void noSwapsAlreadySorted() {
    assertThat(countSwaps(new int[] {1, 2, 3})).isEqualTo(0);
  }

  @Test
  void threeSwapsReverseOrder() {
    assertThat(countSwaps(new int[] {3, 2, 1})).isEqualTo(3);
  }

  @Test
  void sevenSwapsMustBubbleUpElements() {
    assertThat(countSwaps(new int[] {4, 3, 5, 1, 2})).isEqualTo(7);
  }
}
