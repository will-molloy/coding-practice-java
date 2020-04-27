package wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2020-04-27.
 *
 * <p><a
 * href=https://leetcode.com/problems/diagonal-traverse>https://leetcode.com/problems/diagonal-traverse/</a>
 *
 * <p>Difficulty: Medium.
 *
 * <p>Runtime: O(nm)
 *
 * <p>Space: O(nm) (O(1) excluding returned array)
 *
 * <p>Key: Simulating the process of walking through the grid. In particular separate {@code i}
 * variable so don't have to worry about calculating position in 1d array with {@code row} and
 * {@code col} variables.
 *
 * @see P1424DiagonalTraverse2
 */
class P498DiagonalTraverse {

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
