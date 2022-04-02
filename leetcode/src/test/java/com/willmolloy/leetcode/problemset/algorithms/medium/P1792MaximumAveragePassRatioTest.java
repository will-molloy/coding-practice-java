package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1792MaximumAveragePassRatioTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1792MaximumAveragePassRatioTest {

  private static final double TOLERANCE = 10e-5;

  private final P1792MaximumAveragePassRatio p1792MaximumAveragePassRatio =
      new P1792MaximumAveragePassRatio();

  @Test
  void example1() {
    assertThat(
            p1792MaximumAveragePassRatio.maxAverageRatio(new int[][] {{1, 2}, {3, 5}, {2, 2}}, 2))
        .isWithin(TOLERANCE)
        .of(0.78333);
  }

  @Test
  void example2() {
    assertThat(
            p1792MaximumAveragePassRatio.maxAverageRatio(
                new int[][] {{2, 4}, {3, 9}, {4, 5}, {2, 10}}, 4))
        .isWithin(TOLERANCE)
        .of(0.53485);
  }
}
