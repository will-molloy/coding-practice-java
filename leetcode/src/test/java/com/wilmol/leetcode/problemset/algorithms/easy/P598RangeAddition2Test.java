package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P598RangeAddition2Test.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P598RangeAddition2Test {

  private final P598RangeAddition2 p598RangeAddition2 = new P598RangeAddition2();

  @Test
  void example1() {
    assertThat(p598RangeAddition2.maxCount(3, 3, new int[][] {{2, 2}, {3, 3}})).isEqualTo(4);
  }

  @Test
  void example2() {
    assertThat(
            p598RangeAddition2.maxCount(
                3,
                3,
                new int[][] {
                  {2, 2}, {3, 3}, {3, 3}, {3, 3}, {2, 2}, {3, 3}, {3, 3}, {3, 3}, {2, 2}, {3, 3},
                  {3, 3}, {3, 3}
                }))
        .isEqualTo(4);
  }

  @Test
  void example3() {
    assertThat(p598RangeAddition2.maxCount(3, 3, new int[0][])).isEqualTo(9);
  }
}
