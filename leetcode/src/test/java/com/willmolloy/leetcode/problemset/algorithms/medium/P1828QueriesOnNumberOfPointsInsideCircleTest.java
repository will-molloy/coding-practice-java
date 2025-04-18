package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1828QueriesOnNumberOfPointsInsideCircleTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1828QueriesOnNumberOfPointsInsideCircleTest {

  private final P1828QueriesOnNumberOfPointsInsideCircle p1828QueriesOnNumberOfPointsInsideCircle =
      new P1828QueriesOnNumberOfPointsInsideCircle();

  @Test
  void example1() {
    assertThat(
            p1828QueriesOnNumberOfPointsInsideCircle.countPoints(
                new int[][] {{1, 3}, {3, 3}, {5, 3}, {2, 2}},
                new int[][] {{2, 3, 1}, {4, 3, 1}, {1, 1, 2}}))
        .asList()
        .containsExactly(3, 2, 2)
        .inOrder();
  }

  @Test
  void example2() {
    assertThat(
            p1828QueriesOnNumberOfPointsInsideCircle.countPoints(
                new int[][] {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}},
                new int[][] {{1, 2, 2}, {2, 2, 2}, {4, 3, 2}, {4, 3, 3}}))
        .asList()
        .containsExactly(2, 3, 2, 4)
        .inOrder();
  }
}
