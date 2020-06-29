package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/search-a-2d-matrix>https://leetcode.com/problems/search-a-2d-matrix</a>
 *
 * <p>Runtime: O(log nm)
 *
 * <p>Space: O(1)
 *
 * <p>Key: treating as 1d array; formula to deconstruct 'index' into 'rowIndex' and 'colIndex'
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P74SearchA2dMatrix {

  public boolean searchMatrix(int[][] matrix, int target) {
    // binary search, need to convert some 'i' to row/col pair
    // i.e. flatten as 1d array where i is in 0 .. n*m

    if (matrix.length == 0) {
      return false;
    }

    int colSize = matrix.length;
    int rowSize = matrix[0].length;

    // create low/high/mid as if we're dealing with a 1d array
    int low = 0;
    int high = colSize * rowSize - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      // 'deconstruct' mid into 2d coordinates
      // labelling row by row e.g.:
      // [0, 1, 2, 3]
      // [4, 5, 6, 7]

      // divide since count rowSize cells before next row
      int row = mid / rowSize;
      // modulo since col fits into 0..rowSize-1
      int col = mid % rowSize;

      if (matrix[row][col] < target) {
        // need larger value, so search right side
        low = mid + 1;
      } else if (matrix[row][col] > target) {
        // need smaller value, so search left side
        high = mid - 1;
      } else {
        // found target
        return true;
      }
    }
    return false;
  }
}
