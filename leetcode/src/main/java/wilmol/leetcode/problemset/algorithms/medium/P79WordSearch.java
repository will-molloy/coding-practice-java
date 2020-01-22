package wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2020-01-22.
 *
 * <p><a
 * href=https://leetcode.com/problems/word-search>https://leetcode.com/problems/word-search</a>
 *
 * <p>Runtime: O(n*n*w) TODO ?? DFS part is O(w) i.e. longest path searched ??
 *
 * <p>Space: O(1)
 *
 * <p>Key: got the DFS part. Marking node as unused as alternative to copying 'used' boolean array.
 */
class P79WordSearch {

  public boolean exist(char[][] board, String word) {

    // try all starting positions
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        if (exist(board, word, row, col, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean exist(char[][] board, String word, int row, int col, int i) {
    if (i == word.length()) {
      // word is covered
      return true;
    }

    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
      // out of bounds
      return false;
    }

    if (board[row][col] != word.charAt(i)) {
      // incorrect char
      return false;
    }

    // look for next char
    char temp = board[row][col];
    board[row][col] = ' '; // mark as used
    boolean exists =
        exist(board, word, row - 1, col, i + 1) // up
            || exist(board, word, row + 1, col, i + 1) // down
            || exist(board, word, row, col - 1, i + 1) // left
            || exist(board, word, row, col + 1, i + 1); // right
    board[row][col] = temp; // mark as unused
    return exists;
  }
}
