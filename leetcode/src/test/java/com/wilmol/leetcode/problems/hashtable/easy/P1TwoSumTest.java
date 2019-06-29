package com.wilmol.leetcode.problems.hashtable.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-03-30 at 21:49. */
class P1TwoSumTest {

  private static int[] EMPTY = {};

  private static final P1TwoSum OBJ = new P1TwoSum();

  @Test
  void hasSolutions() {
    assertThat(OBJ.solve(new int[] {2, 7, 11, 15}, 9)).isEqualTo(new int[] {0, 1});
    assertThat(OBJ.solve(new int[] {1, 2, 3, 4, 5, 6}, 7)).isEqualTo(new int[] {2, 3});
    assertThat(OBJ.solve(new int[] {3, 2, 1, 0, -1, -2, -3}, -5)).isEqualTo(new int[] {5, 6});
  }

  @Test
  void hasNoSolution() {
    assertThat(OBJ.solve(new int[] {1, 2, 3, 4, 5, 6}, 80)).isEqualTo(EMPTY);
  }
}
