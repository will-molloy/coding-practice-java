package com.wilmol.hackerrank.interview_preparation_kit.arrays.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

class MaxHourGlassSumTest
{

  @Test
  void _6x6Grid()
  {
    int[][] grid = new int[][]{
        { 1, 1, 1, 0, 0, 0 },
        { 0, 1, 0, 0, 0, 0 },
        { 1, 1, 1, 0, 0, 0 },
        { 0, 0, 2, 4, 4, 0 },
        { 0, 0, 0, 2, 0, 0 },
        { 0, 0, 1, 2, 4, 0 }
    };
    assertThat(MaxHourGlassSum.hourglassSum(grid)).isEqualTo(19);
  }

}
