package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P812LargestTriangleAreaTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P812LargestTriangleAreaTest {

  private final P812LargestTriangleArea fun = new P812LargestTriangleArea();

  @Test
  void example() {
    assertThat(fun.largestTriangleArea(new int[][] {{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}}))
        .isWithin(10e-6)
        .of(2);
  }

  @Test
  void triangleEdgesDontLineUpWithAxis() {
    assertThat(fun.largestTriangleArea(new int[][] {{3, 1}, {4, 6}, {6, 5}}))
        .isWithin(10e-6)
        .of(5.5);
  }
}
