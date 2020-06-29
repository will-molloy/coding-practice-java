package com.wilmol.hackerrank.interviewpreparationkit.graphs.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * DfsConnectedCellInAGridTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class DfsConnectedCellInAGridTest {

  @Test
  void sampleTest0TwoRegions() {
    assertThat(
            DfsConnectedCellInAGrid.maxRegion(
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
            DfsConnectedCellInAGrid.maxRegion(
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
            DfsConnectedCellInAGrid.maxRegion(
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
