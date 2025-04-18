package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P969PancakeSortingTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P969PancakeSortingTest {

  private final P969PancakeSorting p969 = new P969PancakeSorting();

  @Test
  void example1() {
    assertThat(p969.pancakeSort(new int[] {3, 2, 4, 1}))
        .containsExactly(3, 4, 2, 3, 1, 2)
        .inOrder();
  }

  @Test
  void example2() {
    assertThat(p969.pancakeSort(new int[] {1, 2, 3})).isEmpty();
  }
}
