package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P130SurroundedRegionsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P130SurroundedRegionsTest {

  private final P130SurroundedRegions fun = new P130SurroundedRegions();

  @Test
  void example() {
    char[][] board = {
      {'X', 'X', 'X', 'X'},
      {'X', 'O', 'O', 'X'},
      {'X', 'X', 'O', 'X'},
      {'X', 'O', 'X', 'X'},
    };
    fun.solve(board);
    assertThat(board)
        .isEqualTo(
            new char[][] {
              {'X', 'X', 'X', 'X'},
              {'X', 'X', 'X', 'X'},
              {'X', 'X', 'X', 'X'},
              {'X', 'O', 'X', 'X'},
            });
  }

  @Test
  void noRows() {
    char[][] board = {};
    fun.solve(board);
    assertThat(board).isEmpty();
  }

  @Test
  void noCols() {
    char[][] board = {{}};
    fun.solve(board);
    assertThat(board).isEqualTo(new char[][] {{}});
  }
}
