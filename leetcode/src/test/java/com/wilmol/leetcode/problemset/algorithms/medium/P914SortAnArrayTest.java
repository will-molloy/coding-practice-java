package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P914SortAnArrayTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P914SortAnArrayTest {

  private final P914SortAnArray fun = new P914SortAnArray();

  // TODO more exhaustive tests? Is there a standard test suite for sorting algorithms?

  @Test
  void example1() {
    assertThat(fun.sortArray(new int[] {5, 2, 3, 1}))
        .asList()
        .containsExactly(1, 2, 3, 5)
        .inOrder();
  }

  @Test
  void example2() {
    assertThat(fun.sortArray(new int[] {5, 1, 1, 2, 0, 0}))
        .asList()
        .containsExactly(0, 0, 1, 1, 2, 5)
        .inOrder();
  }
}
