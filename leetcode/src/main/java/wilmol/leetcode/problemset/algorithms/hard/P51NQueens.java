package wilmol.leetcode.problemset.algorithms.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by wilmol on 2020-02-18.
 *
 * <p><a href=https://leetcode.com/problems/n-queens>https://leetcode.com/problems/n-queens/</a>
 *
 * <p>Runtime: O(n!) TODO is this right? Maybe its O(n * n * n!) ...? (Loop = O(n), canPlaceQueen =
 * O(n), recursion back tracking = O(n!)), but O(n*n!) is still O(n!)???
 *
 * <p>Space: O(n) (depth of recursion)
 *
 * <p>Key: DFS backtracking to generate board permutations (not all permutations... do check board
 * if queens can be placed, don't bother checking row with queen already etc.).
 *
 * @see P37SudokuSolver
 * @see wilmol.leetcode.problemset.algorithms.medium.P1222QueensThatCanAttackTheKing
 */
class P51NQueens {

  public List<List<String>> solveNQueens(int n) {
    return solve(new ArrayList<>(), newEmptyBoard(n), n, 0);
  }

  private List<List<String>> solve(
      List<List<String>> solutions, List<char[]> board, int n, int currentN) {
    if (currentN == n) {
      // new solution
      List<String> solution = board.stream().map(String::new).collect(Collectors.toList());
      solutions.add(solution);
      return solutions;
    }
    // row = currentN because each row needs a queen (or column... have to pick one)
    for (int col = 0; col < n; col++) {
      if (canPlaceQueen(board, currentN, col, n)) {
        // place another queen
        board.get(currentN)[col] = 'Q';
        solve(solutions, board, n, currentN + 1);
        // backtrack
        board.get(currentN)[col] = '.';
      }
    }
    return solutions;
  }

  private List<char[]> newEmptyBoard(int n) {
    return IntStream.range(0, n)
        .mapToObj(
            ignore -> {
              char[] chars = new char[n];
              Arrays.fill(chars, '.');
              return chars;
            })
        .collect(Collectors.toList());
  }

  // O(n)
  private boolean canPlaceQueen(List<char[]> board, int placingRow, int placingCol, int n) {
    // look all 8 directions out from the provided candidate position {placingRow, placingCol}
    for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
      for (int colOffSet = -1; colOffSet <= 1; colOffSet++) {
        if (rowOffset == 0 && colOffSet == 0) {
          continue;
        }
        for (int row = placingRow + rowOffset, col = placingCol + colOffSet;
            row < n && row >= 0 && col < n && col >= 0;
            row += rowOffset, col += colOffSet) {
          if (board.get(row)[col] == 'Q') {
            // encountered a queen which would be able to attack the candidate position
            return false;
          }
        }
      }
    }
    return true;
  }
}
