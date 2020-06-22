package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2019-08-18. */
class P35SearchInsertPositionTest {

  private final P35SearchInsertPosition fun = new P35SearchInsertPosition();

  @Test
  void example1EqualToSomeElementOnRight() {
    assertThat(fun.searchInsert(new int[] {1, 3, 5, 6}, 5)).isEqualTo(2);
  }

  @Test
  void example2LeftSide() {
    assertThat(fun.searchInsert(new int[] {1, 3, 5, 6}, 2)).isEqualTo(1);
  }

  @Test
  void example3NewMax() {
    assertThat(fun.searchInsert(new int[] {1, 3, 5, 6}, 7)).isEqualTo(4);
  }

  @Test
  void example4NewMin() {
    assertThat(fun.searchInsert(new int[] {1, 3, 5, 6}, 0)).isEqualTo(0);
  }

  @Test
  void equalToMin() {
    assertThat(fun.searchInsert(new int[] {1, 3, 5}, 1)).isEqualTo(0);
  }

  @Test
  void equalToMax() {
    assertThat(fun.searchInsert(new int[] {1, 3, 5}, 5)).isEqualTo(2);
  }

  @Test
  void equalToSomeElementOnLeft() {
    assertThat(fun.searchInsert(new int[] {1, 2, 3, 4, 5, 10}, 2)).isEqualTo(1);
  }

  @Test
  void rightSide() {
    assertThat(fun.searchInsert(new int[] {1, 2, 3, 4, 5, 10}, 7)).isEqualTo(5);
  }
}
