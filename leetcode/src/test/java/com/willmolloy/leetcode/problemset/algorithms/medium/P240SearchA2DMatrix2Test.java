package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P240SearchA2DMatrix2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P240SearchA2DMatrix2Test {

  @Test
  void example1() {
    assertThat(
            new P240SearchA2DMatrix2()
                .searchMatrix(
                    new int[][] {
                      {1, 4, 7, 11, 15},
                      {2, 5, 8, 12, 19},
                      {3, 6, 9, 16, 22},
                      {10, 13, 14, 17, 24},
                      {18, 21, 23, 26, 30},
                    },
                    5))
        .isTrue();
  }

  @Test
  void example2() {
    assertThat(
            new P240SearchA2DMatrix2()
                .searchMatrix(
                    new int[][] {
                      {1, 4, 7, 11, 15},
                      {2, 5, 8, 12, 19},
                      {3, 6, 9, 16, 22},
                      {10, 13, 14, 17, 24},
                      {18, 21, 23, 26, 30},
                    },
                    20))
        .isFalse();
  }
}
