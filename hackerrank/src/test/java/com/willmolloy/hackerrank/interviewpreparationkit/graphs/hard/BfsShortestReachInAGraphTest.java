package com.willmolloy.hackerrank.interviewpreparationkit.graphs.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * BfsShortestReachInAGraphTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class BfsShortestReachInAGraphTest {

  @Test
  void list4Node2Edge() {
    assertThat(
            BfsShortestReachInAGraph.bfsAdjList(
                new int[][] {
                  {1, 2},
                  {0},
                  {0},
                  {}
                },
                0))
        .isEqualTo(new int[] {6, 6, -1});
  }

  @Test
  void list3Node1Edge() {
    assertThat(BfsShortestReachInAGraph.bfsAdjList(new int[][] {{}, {2}, {1}}, 1))
        .isEqualTo(new int[] {-1, 6});
  }

  @Test
  void list6Node4Edge() {
    assertThat(
            BfsShortestReachInAGraph.bfsAdjList(
                new int[][] {
                  {1, 4},
                  {0, 2},
                  {1, 3},
                  {2},
                  {0},
                  {}
                },
                0))
        .isEqualTo(new int[] {6, 12, 18, 6, -1});
  }

  @Test
  void matrix4Node2Edge() {
    assertThat(
            BfsShortestReachInAGraph.bfsAdjMatrix(
                new int[][] {
                  {0, 1, 1, 0},
                  {1, 0, 0, 0},
                  {1, 0, 0, 0},
                  {0, 0, 0, 0}
                },
                0))
        .isEqualTo(new int[] {6, 6, -1});
  }

  @Test
  void matrix3Node1Edge() {
    assertThat(
            BfsShortestReachInAGraph.bfsAdjMatrix(
                new int[][] {
                  {0, 0, 0},
                  {0, 0, 1},
                  {0, 1, 0}
                },
                1))
        .isEqualTo(new int[] {-1, 6});
  }

  @Test
  void matrix6Node4Edge() {
    assertThat(
            BfsShortestReachInAGraph.bfsAdjMatrix(
                new int[][] {
                  {0, 1, 0, 0, 1, 0},
                  {1, 0, 1, 0, 0, 0},
                  {0, 1, 0, 1, 0, 0},
                  {0, 0, 1, 0, 0, 0},
                  {1, 0, 0, 0, 0, 0},
                  {0, 0, 0, 0, 0, 0}
                },
                0))
        .isEqualTo(new int[] {6, 12, 18, 6, -1});
  }
}
