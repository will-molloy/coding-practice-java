package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1310XorQueriesOfASubarrayTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1310XorQueriesOfASubarrayTest {

  private final P1310XorQueriesOfASubarray p1310 = new P1310XorQueriesOfASubarray();

  @Test
  void example1() {
    assertThat(
            p1310.xorQueries(new int[] {1, 3, 4, 8}, new int[][] {{0, 1}, {1, 2}, {0, 3}, {3, 3}}))
        .asList()
        .containsExactly(2, 7, 14, 8)
        .inOrder();
  }

  @Test
  void example2() {
    assertThat(
            p1310.xorQueries(new int[] {4, 8, 2, 10}, new int[][] {{2, 3}, {1, 3}, {0, 0}, {0, 3}}))
        .asList()
        .containsExactly(8, 0, 4, 4)
        .inOrder();
  }
}
