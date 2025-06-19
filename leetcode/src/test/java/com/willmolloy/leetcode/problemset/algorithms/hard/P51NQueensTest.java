package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
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
            List.of(".Q..", "...Q", "Q...", "..Q."), List.of("..Q.", "Q...", "...Q", ".Q.."));
  }
}
