package wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2019-12-11.
 *
 * <p><a
 * href=https://leetcode.com/problems/spiral-matrix-ii>https://leetcode.com/problems/spiral-matrix-ii</a>
 *
 * <p>Runtime: O(n*n)
 *
 * <p>Key: going extra on top and right borders so final elements are filled in
 *
 * @see P54SpiralMatrix
 */
class P59SpiralMatrix2 {

  public int[][] generateMatrix(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Expected positive n");
    }

    int[][] matrix = new int[n][n];

    int current = 1;
    int offset = 0;

    // move left -> down -> right -> up until square spiral matrix is filled
    // square because we start at 1 and stop at n*n so must have n rows and n cols
    while (current != n * n + 1) {
      int row = offset;
      int col = offset;

      // top border (move left)
      for (; col < n - offset; col++) {
        matrix[row][col] = current;
        current += 1;
      }
      // since we went 1 element extra on top border, move back in (i.e. right) and down now
      col -= 1; // right
      row += 1; // down

      // right border (move down)
      for (; row < n - offset; row++) {
        matrix[row][col] = current;
        current += 1;
      }
      // since we went 1 element extra on right border, move back in (i.e. up) and right now
      row -= 1; // up
      col -= 1; // right

      // bottom border (move right)
      for (; col >= offset + 1; col--) {
        matrix[row][col] = current;
        current += 1;
      }

      // left border (move up)
      for (; row >= offset + 1; row--) {
        matrix[row][col] = current;
        current += 1;
      }

      offset += 1;
    }
    return matrix;
  }
}
