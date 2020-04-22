package wilmol.leetcode.problemset.algorithms.unknown;

// TODO categorise and change link when leetcode adds this as an official problem

import java.util.Arrays;
import java.util.List;

/**
 * Created by wilmol on 2020-04-22.
 *
 * <p><a
 * href=https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3306>https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3306/</a>
 *
 * <p>TODO Difficulty: Medium?
 *
 * <p>Runtime: O(numRows * log(numCols)) TODO O(numRows + numCols) solution exists
 *
 * <p>Space: O(1)
 *
 * <p>Key: Repeatedly saving {@code firstPos = mid} so when looking left (to check for even earlier
 * 1) the result is kept in case an earlier 1 doesn't exist.
 *
 * @see P34FindFirstAndLastPositionOfElementInSortedArray
 */
class LeftmostColumnWithAtLeastAOne {

  public int leftMostColumnWithOne(BinaryMatrix mat) {
    List<Integer> dimensions = mat.dimensions();
    int numRows = dimensions.get(0);
    int numCols = dimensions.get(1);
    int min = numCols;

    // O(numRows)
    for (int row = 0; row < numRows; row++) {
      int rowMin = colOfFirst1(mat, row, numCols);
      min = Math.min(min, rowMin);
    }
    return min < numCols ? min : -1;
  }

  // O(log(numCols))
  private int colOfFirst1(BinaryMatrix mat, int row, int numCols) {
    int l = 0;
    int r = numCols - 1;
    // default: first pos is beyond the column
    int firstPos = numCols;

    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (mat.get(row, mid) == 1) {
        firstPos = mid;
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return firstPos;
  }

  interface BinaryMatrix {
    int get(int x, int y);

    List<Integer> dimensions();
  }

  static class BinaryMatrixImpl implements BinaryMatrix {

    private final int[][] matrix;

    private int getCalls;

    BinaryMatrixImpl(int[][] matrix) {
      // 1 <= mat.length, mat[i].length <= 100
      // mat[i][j] is either 0 or 1.
      // mat[i] is sorted in a non-decreasing way.
      this.matrix = matrix;
    }

    @Override
    public int get(int x, int y) {
      getCalls = Math.min(getCalls + 1, 1001);
      if (getCalls > 1000) {
        throw new IllegalArgumentException("More than 1000 calls to BinaryMatrix.get");
      }
      return matrix[x][y];
    }

    @Override
    public List<Integer> dimensions() {
      return Arrays.asList(matrix.length, matrix[0].length);
    }
  }
}
