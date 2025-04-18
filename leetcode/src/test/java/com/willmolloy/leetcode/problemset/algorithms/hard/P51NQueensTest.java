package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

/**
 * P51NQueensTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P51NQueensTest {

  private final P51NQueens fun = new P51NQueens();

  @Test
  void example() {
    assertThat(fun.solveNQueens(4))
        .containsExactly(
            ImmutableList.of(".Q..", "...Q", "Q...", "..Q."),
            ImmutableList.of("..Q.", "Q...", "...Q", ".Q.."));
  }
}
