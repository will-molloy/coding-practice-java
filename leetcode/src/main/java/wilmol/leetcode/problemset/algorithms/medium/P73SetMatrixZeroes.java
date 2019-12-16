package wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2019-12-16.
 *
 * <p><a
 * href=https://leetcode.com/problems/set-matrix-zeroes>https://leetcode.com/problems/set-matrix-zeroes</a>
 *
 * <p>Runtime: O(mn)
 *
 * <p>Space: O(1) (this is a goal of the problem as medium difficulty)
 *
 * <p>Key: marking on first iteration; filling in on second iteration. Smart marker variables.
 */
class P73SetMatrixZeroes {

  public void setZeroes(int[][] matrix) {
    int numRows = matrix.length;
    int numCols = matrix[0].length;

    // since the marker "matrix[0][0]" would be shared by first row/first column
    // need separate variable to mark one of them
    // have picked firstColumn here (i.e. using matrix[0][0] for first row)
    boolean firstColumn = false;

    // mark start of rows/cols with 0s if they're to be filled with 0s later on
    // i.e. start of row: matrix[row][0]
    // start of column: matrix[0][col]
    for (int row = 0; row < numRows; row++) {
      if (matrix[row][0] == 0) {
        firstColumn = true;
      }
      // start from 1 since checked first column above
      for (int col = 1; col < numCols; col++) {
        if (matrix[row][col] == 0) {
          matrix[row][0] = 0;
          matrix[0][col] = 0;
        }
      }
    }

    // iterate over matrix again setting entire rows/cols to 0s if marked
    // must do first row/column last else mess with the markers
    for (int row = 1; row < numRows; row++) {
      for (int col = 1; col < numCols; col++) {
        if (matrix[row][0] == 0 || matrix[0][col] == 0) {
          // cell was marked for 0 (by either its row or column)
          matrix[row][col] = 0;
        }
      }
    }
    if (matrix[0][0] == 0) {
      // fill first row with 0s
      for (int col = 0; col < numCols; col++) {
        matrix[0][col] = 0;
      }
    }
    if (firstColumn) {
      // fill first column with 0s
      for (int row = 0; row < numRows; row++) {
        matrix[row][0] = 0;
      }
    }
  }
}
