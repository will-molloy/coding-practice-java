package wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2020-03-29.
 *
 * <p><a
 * href=https://leetcode.com/problems/range-sum-query-2d-immutable>https://leetcode.com/problems/range-sum-query-2d-immutable</a>
 *
 * <p>Runtime: See methods
 *
 * <p>Space: O(m*n) (m = num rows, n = num columns)
 *
 * <p>Key: dynamic programming, ranges
 *
 * @see wilmol.leetcode.problemset.algorithms.easy.P303RangeSumQueryImmutable
 */
class P304RangeSumQuery2dImmutable {

  static class NumMatrix {

    // O(mn) space
    private final int[][] sums;

    // O(mn) time
    NumMatrix(int[][] matrix) {
      if (matrix.length == 0 || matrix[0].length == 0) {
        sums = new int[0][0];
        return;
      }

      // collapse the ranges again (by column)
      // maybe check if more rows than cols and do other way (i.e. whatever is smaller O(n) or O(m))

      // sums[row][col] = sum(matrix[row][0..col])
      sums = new int[matrix.length][matrix[0].length];
      for (int row = 0; row < matrix.length; row++) {
        // [0..0]
        sums[row][0] = matrix[row][0];
        // [0..col] where col = [1..numCols)
        for (int col = 1; col < matrix[0].length; col++) {
          sums[row][col] = matrix[row][col] + sums[row][col - 1];
        }
      }
    }

    // O(m) time TODO this can be O(1), see leetcode discussions page
    int sumRegion(int row1, int col1, int row2, int col2) {
      int sum = 0;
      for (int row = row1; row <= row2; row++) {
        int zeroToCol2 = sums[row][col2];
        int zeroUntilCol1 = col1 == 0 ? 0 : sums[row][col1 - 1];
        // [0..col2] - [0..col1) (same as previous problem)
        sum += zeroToCol2 - zeroUntilCol1;
      }
      return sum;
    }
  }
}
