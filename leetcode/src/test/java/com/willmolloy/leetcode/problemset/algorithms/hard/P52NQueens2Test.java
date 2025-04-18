package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P52NQueens2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P52NQueens2Test {

  private final P52NQueens2 fun = new P52NQueens2();

  @Test
  void example() {
    assertThat(fun.totalNQueens(4)).isEqualTo(2);
  }
}
