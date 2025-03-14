package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a
 * href=https://leetcode.com/problems/sort-the-matrix-diagonally>https://leetcode.com/problems/sort-the-matrix-diagonally/</a>
 *
 * <p>Runtime: O(rows * cols * log(d)) - where d is average diagonal length
 *
 * <p>Extra memory: O(rows * cols)
 *
 * <p>Key idea: {@code row - col} is the diagonal index. (Different to {@link
 * P1424DiagonalTraverse2} as the diagonals point the other way.)
 *
 * @see P498DiagonalTraverse
 * @see P1424DiagonalTraverse2
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1329SortTheMatrixDiagonally {

  public int[][] diagonalSort(int[][] a) {
    int rows = a.length;
    int cols = a[0].length;

    Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        map.computeIfAbsent(row - col, k -> new PriorityQueue<>()).add(a[row][col]);
      }
    }
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        a[row][col] = map.get(row - col).remove();
      }
    }
    return a;
  }
}
