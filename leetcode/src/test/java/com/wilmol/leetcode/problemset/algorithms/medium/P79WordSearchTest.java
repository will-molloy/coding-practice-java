package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P79WordSearchTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P79WordSearchTest {

  private final P79WordSearch fun = new P79WordSearch();

  @Test
  void example() {
    char[][] board = {
      {'A', 'B', 'C', 'E'},
      {'S', 'F', 'C', 'S'},
      {'A', 'D', 'E', 'E'}
    };

    assertThat(fun.exist(board, "ABCCED")).isTrue();
    assertThat(fun.exist(board, "SEE")).isTrue();
    assertThat(fun.exist(board, "ABCB")).isFalse();
  }

  @Test
  void line() {
    char[][] board = {
      {'A', 'B', 'C', 'D'},
    };

    assertThat(fun.exist(board, "A")).isTrue();
    assertThat(fun.exist(board, "B")).isTrue();
    assertThat(fun.exist(board, "ABC")).isTrue();
    assertThat(fun.exist(board, "BCD")).isTrue();
    assertThat(fun.exist(board, "ABCD")).isTrue();

    // gaps
    assertThat(fun.exist(board, "BD")).isFalse();
    assertThat(fun.exist(board, "AC")).isFalse();
    assertThat(fun.exist(board, "AD")).isFalse();

    // repeats
    assertThat(fun.exist(board, "AA")).isFalse();
    assertThat(fun.exist(board, "ABA")).isFalse();
  }

  @Test
  void goesDownAndFailsThenGoesRightAndSucceeds() {
    char[][] board = {
      {'A', 'A', 'A', 'B'},
      {'A', 'X', 'X', 'X'},
      {'A', 'X', 'X', 'X'},
      {'C', 'X', 'X', 'X'},
    };

    assertThat(fun.exist(board, "AAAB")).isTrue();
  }

  @Test
  void goesDownAndFailsThenGoesRightAndSucceedsRevisitingNode() {
    char[][] board = {
      {'A', 'B'},
      {'B', 'C'},
      {'D', 'X'},
      {'E', 'X'},
    };

    assertThat(fun.exist(board, "ABCBDE")).isTrue();
  }
}
