package wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2019-11-03.
 *
 * <p><a
 * href=https://leetcode.com/problems/rotate-image>https://leetcode.com/problems/rotate-image</a>
 *
 * <p>Runtime: O(n^2) - process each element once, matrix is size n*n so... must be n*n (i.e. n^2).
 *
 * <p>Key: 4-way swap to achieve O(1) memory constraint. Also breaking it down with recursion (nxn
 * matrix -> (n-2)x(n-2) matrix).
 *
 * @see P54SpiralMatrix
 */
class P48RotateImage {

  public void rotate(int[][] matrix) {
    if (matrix.length == 0) {
      return;
    }
    if (matrix.length != matrix[0].length) {
      throw new IllegalArgumentException("Not a square matrix");
    }
    // take advantage of the fact it's a square (actually impossible if not square)
    rotate(matrix, 0);
  }

  private static void rotate(int[][] matrix, int depth) {
    // length: size of vector to rotate, shave off depth (twice) and last element
    int length = matrix.length - depth * 2 - 1;
    // base case, no elements to move
    if (length < 1) {
      return;
    }
    // recursive case, rotate each element in the vector in a 4-way swap (i.e. O(1) space achieved)
    for (int i = 0; i < length; i++) {
      // [row,column] !!!

      // element to move:
      // [depth,i]
      // do 4-way move/swap

      // 3x3 want:
      // first recursive case; depth = 0, length = 2
      // first loop:
      // [0,0] [0,2] [2,2] [2,0]
      // second loop:
      // [0,1] [1,2] [2,1] [1,0]

      // 4x4 want:
      // first recursive case; depth = 0, length = 3
      // i = 0
      // [0,0] [0,3] [3,3] [3,0]
      // i = 1
      // [0,1] [1,3] [3,2] [2,0]
      // i = 2
      // [0,2] [2,3] [3,1] [1,0]
      // second recursive case; depth = 1, length = 1
      // (essentially a 2x2 matrix now with depth offset of 1)
      // i = 0
      // [1,1] [1,2] [2,2] [2,1]

      // only the value which changes across iterations needs 'i'
      // since it's a square, should only be 4 unique values here:
      // depth, i+depth, length+depth, length+depth-i

      // the four elements are:
      // [depth,i+depth] [i+depth,length+depth] [length+depth,length+depth-i] [length+depth-i,depth]

      // do the 4-way swap
      final int first = matrix[depth][i + depth];
      final int second = matrix[i + depth][length + depth];
      final int third = matrix[length + depth][length + depth - i];
      final int fourth = matrix[length + depth - i][depth];
      matrix[i + depth][length + depth] = first;
      matrix[length + depth][length + depth - i] = second;
      matrix[length + depth - i][depth] = third;
      matrix[depth][i + depth] = fourth;
    }
    rotate(matrix, depth + 1);
  }
}
