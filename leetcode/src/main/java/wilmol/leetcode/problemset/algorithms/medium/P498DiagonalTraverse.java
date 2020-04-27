package wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wilmol on 2020-04-27.
 *
 * <p><a
 * href=https://leetcode.com/problems/diagonal-traverse>https://leetcode.com/problems/diagonal-traverse/</a>
 *
 * <p>Difficulty: Medium.
 *
 * @see P1424DiagonalTraverse2
 */
interface P498DiagonalTraverse {

  int[] findDiagonalOrder(int[][] matrix);

  /**
   * Solution which simulates the diagonal traversal walk.
   *
   * <p>Runtime: O(nm)
   *
   * <p>Space: O(1)
   *
   * <p>Key: Simulating the process of walking through the grid. In particular separate {@code i}
   * variable so don't have to worry about calculating position in 1d array with {@code row} and
   * {@code col} variables.
   */
  class SimulateWalk implements P498DiagonalTraverse {

    @Override
    public int[] findDiagonalOrder(int[][] matrix) {
      if (matrix.length == 0 || matrix[0].length == 0) {
        return new int[0];
      }

      int n = matrix.length;
      int m = matrix[0].length;

      int size = n * m;
      int[] result = new int[size];

      int i = 0;

      int row = 0;
      int col = 0;

      boolean up = true;

      while (i < size) {
        result[i++] = matrix[row][col];

        if (up) {
          if (row == 0 && col < m - 1) {
            // reached first row, not last column
            col++;
            up = false;
          } else if (col == m - 1) {
            // reached last column
            row++;
            up = false;
          } else {
            // can still move up on diagonal
            row--;
            col++;
          }
        } else {
          if (row == n - 1 && col >= 0) {
            // reached last row, not first column
            col++;
            up = true;
          } else if (col == 0) {
            // reached first column
            row++;
            up = true;
          } else {
            // can still move down on diagonal
            row++;
            col--;
          }
        }
      }
      return result;
    }
  }

  /**
   * Solution which collects the diagonals.
   *
   * <p>Runtime: O(nm)
   *
   * <p>Space: O(nm)
   *
   * <p>Key: Adding {@code row} and {@code col} produces the diagonal index:
   *
   * <p><img src="https://i.imgur.com/MRDn9hS.png" />
   */
  class CollectDiagonals implements P498DiagonalTraverse {

    @Override
    public int[] findDiagonalOrder(int[][] matrix) {
      int n = matrix.length;
      if (n == 0) {
        return new int[0];
      }
      int m = matrix[0].length;

      // collect diagonals
      List<List<Integer>> diagonals = new ArrayList<>();
      int size = 0;

      for (int row = 0; row < n; row++) {
        for (int col = 0; col < m; col++) {
          int diagonalIndex = row + col;
          if (diagonalIndex >= diagonals.size()) {
            diagonals.add(new ArrayList<>());
          }
          diagonals.get(diagonalIndex).add(matrix[row][col]);
          size++;
        }
      }

      // flatten into result array
      int[] result = new int[size];
      int i = 0;
      boolean up = true;
      for (List<Integer> list : diagonals) {
        if (up) {
          // if diagonal moves up need to reverse because we added the end (earlier row) first
          Collections.reverse(list);
        }
        up = !up;
        for (int e : list) {
          result[i++] = e;
        }
      }
      return result;
    }
  }
}
