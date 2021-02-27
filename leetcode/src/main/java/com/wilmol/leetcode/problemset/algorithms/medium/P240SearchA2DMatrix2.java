package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/search-a-2d-matrix-ii>https://leetcode.com/problems/search-a-2d-matrix-ii/</a>
 *
 * <p>Runtime: O(rows + cols)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Search rows/cols in opposite sorted direction (start in either top right or bottom left).
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 * @see P74SearchA2dMatrix
 */
class P240SearchA2DMatrix2 {

  public boolean searchMatrix(int[][] matrix, int target) {
    int rows = matrix.length;
    int cols = matrix[0].length;

    // start in top right (search rows in ascending order and columns in descending order)
    int row = 0;
    int col = cols - 1;
    while (col >= 0 && row < rows) {
      if (target > matrix[row][col]) {
        // target larger, go to row with larger values
        row++;
      } else if (target < matrix[row][col]) {
        // target smaller, go to column with smaller values
        col--;
      } else {
        // target found
        return true;
      }
    }
    return false;
  }
}
