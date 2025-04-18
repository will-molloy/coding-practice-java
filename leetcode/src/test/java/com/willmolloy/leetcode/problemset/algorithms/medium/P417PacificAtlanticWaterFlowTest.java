package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P417PacificAtlanticWaterFlowTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P417PacificAtlanticWaterFlowTest {

  private final P417PacificAtlanticWaterFlow p417PacificAtlanticWaterFlow =
      new P417PacificAtlanticWaterFlow();

  @Test
  void example1() {
    assertThat(
            p417PacificAtlanticWaterFlow.pacificAtlantic(
                new int[][] {
                  {1, 2, 2, 3, 5},
                  {3, 2, 3, 4, 4},
                  {2, 4, 5, 3, 1},
                  {6, 7, 1, 4, 5},
                  {5, 1, 1, 2, 4},
                }))
        .containsExactly(
            List.of(0, 4),
            List.of(1, 3),
            List.of(1, 4),
            List.of(2, 2),
            List.of(3, 0),
            List.of(3, 1),
            List.of(4, 0));
  }

  @Test
  void example2() {
    assertThat(
            p417PacificAtlanticWaterFlow.pacificAtlantic(
                new int[][] {
                  {2, 1},
                  {1, 2},
                }))
        .containsExactly(List.of(0, 0), List.of(0, 1), List.of(1, 0), List.of(1, 1));
  }
}
