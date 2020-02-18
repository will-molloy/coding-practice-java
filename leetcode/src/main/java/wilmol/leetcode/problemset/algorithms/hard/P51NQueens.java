package wilmol.leetcode.problemset.algorithms.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by wilmol on 2020-02-18.
 *
 * <p><a href=https://leetcode.com/problems/n-queens>https://leetcode.com/problems/n-queens</a>
 *
 * <p>Runtime: O(n!) TODO is this right? Maybe its O(n * n * n!) ...? (Loop = O(n), canPlaceQueen =
 * O(n), recursion back tracking = O(n!)), but O(n*n!) is still O(n!)???
 *
 * <p>Space: O(n) (depth of recursion)
 *
 * <p>Key: DFS backtracking to generate all permutations
 *
 * @see P37SudokuSolver
 */
class P51NQueens {

  public List<List<String>> solveNQueens(int n) {
    return solve(new ArrayList<>(), emptyBoard(n), n, 0);
  }

  private List<List<String>> solve(
      List<List<String>> solutions, List<char[]> board, int targetN, int currentN) {
    if (currentN == targetN) {
      // new solution
      List<String> solution = board.stream().map(String::new).collect(Collectors.toList());
      solutions.add(solution);
      return solutions;
    }
    // row = currentN because each row needs a queen (or column... have to pick one)
    for (int col = 0; col < targetN; col++) {
      if (canPlaceQueen(board, currentN, col, targetN)) {
        board.get(currentN)[col] = 'Q';
        solve(solutions, board, targetN, currentN + 1);
        // backtrack
        board.get(currentN)[col] = '.';
      }
    }
    return solutions;
  }

  private List<char[]> emptyBoard(int n) {
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
  private boolean canPlaceQueen(List<char[]> board, int row, int col, int n) {
    for (int i = 0; i < n; i++) {

      // check row
      if (board.get(row)[i] == 'Q') {
        return false;
      }

      // check col
      if (board.get(i)[col] == 'Q') {
        return false;
      }

      // check diagonals
      // from bottom right
      if (row + i < n && col + i < n) {
        if (board.get(row + i)[col + i] == 'Q') {
          return false;
        }
      }
      // from bottom left
      if (row + i < n && col - i >= 0) {
        if (board.get(row + i)[col - i] == 'Q') {
          return false;
        }
      }
      // from top right
      if (row - i >= 0 && col + i < n) {
        if (board.get(row - i)[col + i] == 'Q') {
          return false;
        }
      }
      // from top left
      if (row - i >= 0 && col - i >= 0) {
        if (board.get(row - i)[col - i] == 'Q') {
          return false;
        }
      }
    }
    return true;
  }
}
