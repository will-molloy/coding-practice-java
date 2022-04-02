package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/game-of-life>https://leetcode.com/problems/game-of-life/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Copy the board first.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P289GameOfLife {

  public void gameOfLife(int[][] board) {
    int rows = board.length;
    int cols = board[0].length;

    int[][] copy = new int[rows][cols];
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        copy[row][col] = board[row][col];
      }
    }

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        int count = 0;

        for (int r = row - 1; r <= row + 1; r++) {
          for (int c = col - 1; c <= col + 1; c++) {
            if (r < 0 || r >= rows || c < 0 || c >= cols || row == r && col == c) {
              continue;
            }
            if (copy[r][c] == 1) {
              count++;
            }
          }
        }

        if (copy[row][col] == 1 && (count < 2 || count > 3)) {
          board[row][col] = 0;
        }
        if (copy[row][col] == 0 && count == 3) {
          board[row][col] = 1;
        }
      }
    }
  }
}
