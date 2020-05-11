package wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2020-04-10.
 *
 * <p><a
 * href=https://leetcode.com/problems/surrounded-regions>https://leetcode.com/problems/surrounded-regions</a>
 *
 * <p>Runtime: O(row * col)
 *
 * <p>Space: O(row * col) (worst case recursion stack size - whole board is 'O's)
 *
 * <p>Key: better to mark regions which we don't want to flip first (a sort of preprocessing)
 *
 * @see P200NumberOfIslands
 * @see wilmol.leetcode.problemset.algorithms.easy.P733FloodFill
 */
class P130SurroundedRegions {

  // precondition:
  // board[i].length is the same for all i = [0..board.length)

  public void solve(char[][] board) {
    if (board.length == 0 || board[0].length == 0) {
      return;
    }

    // run DFS from 'O's on edges, marking regions of 'O's that should NOT be flipped (as 'o's)
    for (int row = 0; row < board.length; row++) {
      // first col
      if (board[row][0] == 'O') {
        mark(board, row, 0);
      }
      // last col
      if (board[row][board[0].length - 1] == 'O') {
        mark(board, row, board[0].length - 1);
      }
    }
    for (int col = 0; col < board[0].length; col++) {
      // first row
      if (board[0][col] == 'O') {
        mark(board, 0, col);
      }
      // last row
      if (board[board.length - 1][col] == 'O') {
        mark(board, board.length - 1, col);
      }
    }

    // can now turn all 'O's into 'X's and all 'o's back into 'O's
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        if (board[row][col] == 'O') {
          board[row][col] = 'X';
        } else if (board[row][col] == 'o') {
          board[row][col] = 'O';
        }
      }
    }
  }

  private void mark(char[][] board, int row, int col) {
    // careful with this condition
    // if doing the inverse (checking inverse and 'return' if true - i.e. a guard expression)
    // then need to check for 'X' AND 'o' else get stackoverflow cause it bounces between 'o's
    // hence why I prefer to do it this way
    if (row >= 0
        && row < board.length
        && col >= 0
        && col < board[0].length
        && board[row][col] == 'O') {
      board[row][col] = 'o';
      mark(board, row + 1, col);
      mark(board, row - 1, col);
      mark(board, row, col + 1);
      mark(board, row, col - 1);
    }
  }
}
