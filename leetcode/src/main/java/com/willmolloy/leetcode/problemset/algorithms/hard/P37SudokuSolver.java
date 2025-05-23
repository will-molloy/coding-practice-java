package com.willmolloy.leetcode.problemset.algorithms.hard;

/**
 * <a
 * href=https://leetcode.com/problems/sudoku-solver>https://leetcode.com/problems/sudoku-solver</a>
 *
 * <p>Runtime: O(9<sup>n</sup>) (n = number of initially empty squares) TODO probably exists a more
 * optimal solution
 *
 * <p>Space: O(1)
 *
 * <p>Key idea: knowing that pure bruteforce (via. recursive backtracking) is fine for small inputs
 *
 * @see P51NQueens
 * @see P212WordSearch2
 * @see P980UniquePaths3
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P37SudokuSolver {

  // given Sudoku puzzle will have a single unique solution.

  public void solveSudoku(char[][] board) {
    solve(board);
  }

  private boolean solve(char[][] board) {
    // find all 'empty' squares
    for (int row = 0; row < 9; row++) {
      for (int col = 0; col < 9; col++) {
        if (board[row][col] == '.') {
          // try '1' to '9' for the empty square
          for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, row, col, c)) {
              // allowed to use 'c'
              board[row][col] = c;
              if (solve(board)) {
                // solved with 'c'
                return true;
              } else {
                // didn't solve with 'c', go back
                board[row][col] = '.';
              }
            }
          }
          // nothing worked for the empty square, must have deprived the boards solution previously
          return false;
        }
      }
    }
    // all squares checked and solution found
    return true;
  }

  // checks if 'c' can be inserted into the board at (row, col) without violating sudoku rules
  private boolean isValid(char[][] board, int row, int col, char c) {
    for (int i = 0; i < 9; i++) {
      // check row
      if (board[i][col] == c) {
        return false;
      }
      // check column
      if (board[row][i] == c) {
        return false;
      }
      // check 3x3 block
      if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
        return false;
      }
    }
    return true;
  }
}
