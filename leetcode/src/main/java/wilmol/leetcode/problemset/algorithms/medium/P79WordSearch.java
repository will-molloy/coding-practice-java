package wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2020-01-22.
 *
 * <p><a
 * href=https://leetcode.com/problems/word-search>https://leetcode.com/problems/word-search</a>
 *
 * <p>Runtime: TODO O()
 *
 * <p>Space: TODO O()
 *
 * <p>TODO Key:
 */
class P79WordSearch {

  public boolean exist(char[][] board, String word) {

    // try all starting positions (INEFFICIENT?)
    boolean[][] used = new boolean[board.length][board[0].length];
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        if (exist(board, word, used, row, col, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean exist(char[][] board, String word, boolean[][] used, int row, int col, int i) {
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || used[row][col]) {
      return false;
    }

    if (board[row][col] != word.charAt(i)) {
      used[row][col] = false;
      return false;
    }

    i++;
    // was final char?
    if (i == word.length()) {
      return true;
    }

    used = copy(used);
    used[row][col] = true;

    // look for next char

    return exist(board, word, used, row - 1, col, i) // up
        || exist(board, word, used, row + 1, col, i) // down
        || exist(board, word, used, row, col - 1, i) // left
        || exist(board, word, used, row, col + 1, i); // right
  }

  private boolean[][] copy(boolean[][] original) {
    boolean[][] copy = new boolean[original.length][original[0].length];
    for (int i = 0; i < original.length; i++) {
      System.arraycopy(original[i], 0, copy[i], 0, original[i].length);
    }
    return copy;
  }
}
