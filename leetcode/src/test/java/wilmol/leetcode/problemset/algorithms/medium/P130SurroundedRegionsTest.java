package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-10. */
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
