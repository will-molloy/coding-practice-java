package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/image-overlap>https://leetcode.com/problems/image-overlap/</a>
 *
 * <p>Runtime: O(n<sup>4</sup>)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Brute force; try all combinations of shifting in x and y direction.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P835ImageOverlap {

  public int largestOverlap(int[][] a, int[][] b) {
    // a and b have same dimensions, only need to shift one
    int rows = a.length;
    int cols = a[0].length;

    int maxCount = 0;
    for (int rs = -(rows - 1); rs <= rows - 1; rs++) {
      for (int cs = -(cols - 1); cs <= cols - 1; cs++) {
        int count = 0;
        for (int r = 0; r < rows; r++) {
          for (int c = 0; c < cols; c++) {
            if (r + rs < 0 || r + rs >= rows || c + cs < 0 || c + cs >= cols) {
              continue;
            }
            count += a[r + rs][c + cs] & b[r][c];
          }
        }
        maxCount = Math.max(maxCount, count);
      }
    }
    return maxCount;
  }
}
