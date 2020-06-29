package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/queens-that-can-attack-the-king>https://leetcode.com/problems/queens-that-can-attack-the-king/</a>
 *
 * <p>Difficulty: Medium.
 *
 * <p>Runtime: O(1) (for NxN board it would be O(queens + N))
 *
 * <p>Space: O(1) (for NxN board it would be O(N<sup>2</sup>) using array, O(queens) using hashset)
 *
 * <p>Key: Look out from king, rather than in from each queen.
 *
 * @see com.wilmol.leetcode.problemset.algorithms.hard.P51NQueens
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1222QueensThatCanAttackTheKing {

  public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
    // dump queens into array for O(1) lookup
    boolean[][] board = new boolean[8][8];
    // O(queens)
    for (int[] queen : queens) {
      board[queen[0]][queen[1]] = true;
    }

    // look out from king, all 8 directions
    List<List<Integer>> result = new ArrayList<>();
    // O(4N) = O(N)
    for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
      for (int colOffset = -1; colOffset <= 1; colOffset++) {
        if (rowOffset == 0 && colOffset == 0) {
          continue;
        }
        for (int row = king[0] + rowOffset, col = king[1] + colOffset;
            row < 8 && row >= 0 && col < 8 && col >= 0;
            row += rowOffset, col += colOffset) {
          if (board[row][col]) {
            result.add(Arrays.asList(row, col));
            // stop after first queen, others are blocked
            break;
          }
        }
      }
    }
    return result;
  }
}
