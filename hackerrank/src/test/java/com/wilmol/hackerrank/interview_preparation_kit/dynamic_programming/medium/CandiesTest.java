package com.wilmol.hackerrank.interview_preparation_kit.dynamic_programming.medium;

import static com.google.common.truth.Truth.assertThat;
import static com.wilmol.hackerrank.interview_preparation_kit.dynamic_programming.medium.Candies.candies;

import org.junit.jupiter.api.Test;

class CandiesTest
{

  @Test
  void sampleTest0SameScoreButDifferentCandies()
  {
    // can complete in one pass
    assertThat(candies(new int[]{ 1, 2, 2 })).isEqualTo(4L);
  }

  @Test
  void sampleTest1MustMultiplePassesNeeded()
  {
    // right side must be completed first (for the 9, 2, 1 part)
    assertThat(candies(new int[]{ 2, 4, 2, 6, 1, 7, 8, 9, 2, 1 })).isEqualTo(19L);
  }

  @Test
  void sampleTest2AlternatingCandies()
  {
    // 1, 2, 1, 2 ...
    assertThat(candies(new int[]{ 2, 4, 3, 5, 2, 6, 4, 5 })).isEqualTo(12L);
  }

  @Test
  void decreasingCandiesGiven()
  {
    // score matches candy given
    assertThat(candies(new int[]{ 5, 4, 3, 2, 1 })).isEqualTo(15L);
  }

}
