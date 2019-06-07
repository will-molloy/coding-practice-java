package com.wilmol.hackerrank.interview_preparation_kit.sorting.easy;

import static com.google.common.truth.Truth.assertThat;
import static com.wilmol.hackerrank.interview_preparation_kit.sorting.easy.BubbleSortCountSwaps.countSwaps;

import org.junit.jupiter.api.Test;

class BubbleSortCountSwapsTest
{

  @Test
  void noSwapsAlreadySorted()
  {
    assertThat(countSwaps(new int[]{ 1, 2, 3 })).isEqualTo(0);
  }

  @Test
  void _3SwapsReverseOrder()
  {
    assertThat(countSwaps(new int[]{ 3, 2, 1 })).isEqualTo(3);
  }

  @Test
  void _7SwapsMustBubbleUpElements()
  {
    assertThat(countSwaps(new int[]{ 4, 3, 5, 1, 2 })).isEqualTo(7);
  }

}
