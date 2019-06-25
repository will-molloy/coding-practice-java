package com.wilmol.hackerrank.interview_preparation_kit.graphs.hard;

import static com.google.common.truth.Truth.assertThat;
import static com.wilmol.hackerrank.interview_preparation_kit.graphs.hard.DfsConnectedCellInAGrid.maxRegion;

import org.junit.jupiter.api.Test;

class DfsConnectedCellInAGridTest {

  @Test
  void sampleTest0TwoRegions() {
    assertThat(
            maxRegion(
                new int[][] {
                  {1, 1, 0, 0},
                  {0, 1, 1, 0},
                  {0, 0, 1, 0},
                  {1, 0, 0, 0},
                }))
        .isEqualTo(5);
  }

  @Test
  void sampleTest1OneRegion() {
    assertThat(
            maxRegion(
                new int[][] {
                  {0, 0, 1, 1},
                  {0, 0, 1, 0},
                  {0, 1, 1, 0},
                  {0, 1, 0, 0},
                  {1, 1, 0, 0},
                }))
        .isEqualTo(8);
  }

  @Test
  void sampleTest2TwoRegions() {
    assertThat(
            maxRegion(
                new int[][] {
                  {1, 0, 1, 1, 0},
                  {1, 1, 0, 0, 1},
                  {0, 1, 1, 1, 0},
                  {0, 0, 0, 0, 1},
                  {1, 1, 1, 0, 0}
                }))
        .isEqualTo(10);
  }
}
