package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P34FindFirstAndLastPositionOfElementInSortedArrayTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P34FindFirstAndLastPositionOfElementInSortedArrayTest {

  private final P34FindFirstAndLastPositionOfElementInSortedArray fun =
      new P34FindFirstAndLastPositionOfElementInSortedArray();

  @Test
  void example1() {
    assertThat(fun.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8))
        .asList()
        .containsExactly(3, 4)
        .inOrder();
  }

  @Test
  void example2() {
    assertThat(fun.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 6)).asList().containsExactly(-1, -1);
  }

  @Test
  void sameLocation() {
    assertThat(fun.searchRange(new int[] {5, 6, 7, 7, 8, 8, 10}, 6)).asList().containsExactly(1, 1);
  }

  @Test
  void sameElementRepeated() {
    assertThat(fun.searchRange(new int[] {5, 5, 5, 5, 5, 5}, 5))
        .asList()
        .containsExactly(0, 5)
        .inOrder();
  }

  @Test
  void emptyInput() {
    assertThat(fun.searchRange(new int[0], 5)).asList().containsExactly(-1, -1);
  }

  @Test
  void singletonInput() {
    assertThat(fun.searchRange(new int[] {5}, 5)).asList().containsExactly(0, 0);
  }
}
