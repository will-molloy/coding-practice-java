package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

/**
 * P62UniquePathsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P62UniquePathsTest {

  private final P62UniquePaths recursive = new P62UniquePaths.TopDownRecursive();

  private final P62UniquePaths dp = new P62UniquePaths.BottomUpDp();

  @Test
  void example1() {
    assertAll(
        () -> assertThat(recursive.uniquePaths(3, 2)).isEqualTo(3),
        () -> assertThat(dp.uniquePaths(3, 2)).isEqualTo(3));
  }

  @Test
  void example2() {
    assertAll(
        () -> assertThat(recursive.uniquePaths(7, 3)).isEqualTo(28),
        () -> assertThat(dp.uniquePaths(7, 3)).isEqualTo(28));
  }
}
