package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P33SearchInRotatedSortedArrayTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P33SearchInRotatedSortedArrayTest {

  private final P33SearchInRotatedSortedArray fun = new P33SearchInRotatedSortedArray();

  @Test
  void example1() {
    assertThat(fun.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0)).isEqualTo(4);
  }

  @Test
  void example2() {
    assertThat(fun.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 3)).isEqualTo(-1);
  }

  @Test
  void notRotated() {
    assertThat(fun.search(new int[] {0, 1, 2, 3, 4, 5, 6, 7}, 5)).isEqualTo(5);
  }

  @Test
  void largerGapsBetweenElements() {
    assertThat(fun.search(new int[] {40, 500, 20, 25, 26, 31}, 40)).isEqualTo(0);
  }

  @Test
  void emptyArray() {
    assertThat(fun.search(new int[0], 1)).isEqualTo(-1);
  }
}
