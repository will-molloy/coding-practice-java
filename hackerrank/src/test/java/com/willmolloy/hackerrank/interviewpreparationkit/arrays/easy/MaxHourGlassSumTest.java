package com.willmolloy.hackerrank.interviewpreparationkit.arrays.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * MaxHourGlassSumTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class MaxHourGlassSumTest {

  @Test
  void grid6x6() {
    int[][] grid =
        new int[][] {
          {1, 1, 1, 0, 0, 0},
          {0, 1, 0, 0, 0, 0},
          {1, 1, 1, 0, 0, 0},
          {0, 0, 2, 4, 4, 0},
          {0, 0, 0, 2, 0, 0},
          {0, 0, 1, 2, 4, 0}
        };
    assertThat(MaxHourGlassSum.hourglassSum(grid)).isEqualTo(19);
  }
}
