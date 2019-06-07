package com.wilmol.hackerrank.interview_preparation_kit.greedy_algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

class MaxMinUnfairnessTest
{

  @Test
  void sublistInMiddleOfSortedList()
  {
    // set(30, 20, 10) -> 30 - 10 = 20
    assertThat(MaxMinUnfairness.maxMin(3, new int[]{ 10, 100, 300, 200, 1000, 20, 30 })).isEqualTo(20);
  }

  @Test
  void sublistAtStartOfList()
  {
    // set(1, 2, 3, 4) -> 4 - 1 = 3
    assertThat(MaxMinUnfairness.maxMin(4, new int[]{ 1, 2, 3, 4, 10, 20, 30, 40, 100, 200 })).isEqualTo(3);
  }

  @Test
  void sublistOfSameElements()
  {
    // set(1, 1, 1) -> 1 - 1 = 0
    assertThat(MaxMinUnfairness.maxMin(3, new int[]{ 1, 1, 2, 1, 2 })).isEqualTo(0);
  }

  @Test
  void sublistAtEndOfList()
  {
    // set(402, 401, 400) -> 402 - 400 = 2
    assertThat(MaxMinUnfairness.maxMin(3, new int[]{ 100, 200, 300, 350, 400, 401, 402 })).isEqualTo(2);
  }

}
