package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P980UniquePaths3Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P980UniquePaths3Test {

  @Test
  void example1() {
    assertThat(
            new P980UniquePaths3()
                .uniquePathsIII(
                    new int[][] {
                      {1, 0, 0, 0},
                      {0, 0, 0, 0},
                      {0, 0, 2, -1},
                    }))
        .isEqualTo(2);
  }

  @Test
  void example2() {
    assertThat(
            new P980UniquePaths3()
                .uniquePathsIII(
                    new int[][] {
                      {1, 0, 0, 0},
                      {0, 0, 0, 0},
                      {0, 0, 0, 2},
                    }))
        .isEqualTo(4);
  }

  @Test
  void example3() {
    assertThat(
            new P980UniquePaths3()
                .uniquePathsIII(
                    new int[][] {
                      {0, 1},
                      {2, 0},
                    }))
        .isEqualTo(0);
  }

  @Test
  void onePath() {
    assertThat(
            new P980UniquePaths3()
                .uniquePathsIII(
                    new int[][] {
                      {1, 0, 0, 0, 2},
                    }))
        .isEqualTo(1);
  }
}
