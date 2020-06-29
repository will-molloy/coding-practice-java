package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P81SearchInRotatedSortedArray2Test.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P81SearchInRotatedSortedArray2Test {

  private final P81SearchInRotatedSortedArray2 fun = new P81SearchInRotatedSortedArray2();

  @Test
  void example1() {
    assertThat(fun.search(new int[] {2, 5, 6, 0, 0, 1, 2}, 0)).isTrue();
  }

  @Test
  void example2() {
    assertThat(fun.search(new int[] {2, 5, 6, 0, 0, 1, 2}, 3)).isFalse();
  }

  @Test
  void failedToFindLeftRotation() {
    assertThat(fun.search(new int[] {2, 2, 2, 0, 2, 2}, 0)).isTrue();
  }
}
