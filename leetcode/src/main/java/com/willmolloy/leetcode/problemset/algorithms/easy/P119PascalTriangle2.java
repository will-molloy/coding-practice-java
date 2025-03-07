package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/pascals-triangle-ii>https://leetcode.com/problems/pascals-triangle-ii</a>
 *
 * <p>Runtime: O(n<sup>2</sup>) TODO can be O(n) with some math formula
 *
 * <p>Space: O(k)
 *
 * <p>Key idea: optimising DP for reduced space use by iterating backwards
 *
 * @see P118PascalTriangle
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P119PascalTriangle2 {

  public List<Integer> getRow(int k) {
    List<Integer> row = new ArrayList<>();
    row.add(1);

    for (int i = 0; i < k; i++) {
      // iterate backwards so the row can be updated in-place
      // (otherwise loop dependency (j - 1) is overwritten)
      for (int j = i; j >= 1; j--) {
        row.set(j, row.get(j - 1) + row.get(j));
      }
      row.add(1);
    }

    return row;
  }
}
