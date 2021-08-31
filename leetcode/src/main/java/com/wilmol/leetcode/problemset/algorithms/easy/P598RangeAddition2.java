package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/range-addition-ii>https://leetcode.com/problems/range-addition-ii/</a>
 *
 * <p>Runtime: O({@code ops})
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: These max integers will always be in a rectangle in the top left, since all ops apply out
 * from (0, 0). So answer is simply min op[0] * min op[1].
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P598RangeAddition2 {

  public int maxCount(int rows, int cols, int[][] ops) {
    int minRow = rows;
    int minCol = cols;

    for (int[] op : ops) {
      minRow = Math.min(minRow, op[0]);
      minCol = Math.min(minCol, op[1]);
    }

    return minRow * minCol;
  }
}
