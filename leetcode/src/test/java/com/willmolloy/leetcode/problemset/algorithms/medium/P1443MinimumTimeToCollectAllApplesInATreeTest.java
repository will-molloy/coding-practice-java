package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

/**
 * P1443MinimumTimeToCollectAllApplesInATreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1443MinimumTimeToCollectAllApplesInATreeTest {

  private final P1443MinimumTimeToCollectAllApplesInATree p1443 =
      new P1443MinimumTimeToCollectAllApplesInATree();

  @Test
  void example1() {
    assertThat(
            p1443.minTime(
                7,
                new int[][] {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}},
                ImmutableList.of(false, false, true, false, true, true, false)))
        .isEqualTo(8);
  }

  @Test
  void example2() {
    assertThat(
            p1443.minTime(
                7,
                new int[][] {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}},
                ImmutableList.of(false, false, true, false, false, true, false)))
        .isEqualTo(6);
  }

  @Test
  void example3() {
    assertThat(
            p1443.minTime(
                7,
                new int[][] {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}},
                ImmutableList.of(false, false, false, false, false, false, false)))
        .isEqualTo(0);
  }

  @Test
  void onePath() {
    assertThat(
            p1443.minTime(
                5,
                new int[][] {{0, 1}, {0, 2}, {0, 3}, {1, 4}},
                ImmutableList.of(false, false, false, false, true)))
        .isEqualTo(4);
  }

  @Test
  void allHaveApples() {
    assertThat(
            p1443.minTime(
                7,
                new int[][] {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}},
                ImmutableList.of(true, true, true, true, true, true, true)))
        .isEqualTo(12);
  }
}
