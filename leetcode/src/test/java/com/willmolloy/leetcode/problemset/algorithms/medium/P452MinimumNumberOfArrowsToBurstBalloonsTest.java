package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P452MinimumNumberOfArrowsToBurstBalloonsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P452MinimumNumberOfArrowsToBurstBalloonsTest {

  private final P452MinimumNumberOfArrowsToBurstBalloons p452 =
      new P452MinimumNumberOfArrowsToBurstBalloons();

  @Test
  void example() {
    assertThat(p452.findMinArrowShots(new int[][] {{10, 16}, {2, 8}, {1, 6}, {7, 12}}))
        .isEqualTo(2);
  }

  @Test
  void lastDoesntOverlap() {
    assertThat(p452.findMinArrowShots(new int[][] {{10, 16}, {2, 8}, {1, 6}, {7, 12}, {40, 50}}))
        .isEqualTo(3);
  }

  @Test
  void lastTwoMeanFirstIntervalNoLongerOverlaps() {
    assertThat(
            p452.findMinArrowShots(new int[][] {{10, 16}, {2, 8}, {1, 6}, {7, 12}, {7, 7}, {7, 7}}))
        .isEqualTo(3);
  }
}
