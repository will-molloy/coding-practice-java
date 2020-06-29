package com.wilmol.leetcode.problemset.algorithms.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/pascals-triangle>https://leetcode.com/problems/pascals-triangle</a>
 *
 * <p>Runtime: O(n<sup>2</sup>)
 *
 * <p>Space: O(n<sup>2</sup>)
 *
 * <p>Key: just coded the steps in the visualisation (dynamic programming)
 *
 * @see P119PascalTriangle2
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P118PascalTriangle {

  public List<List<Integer>> generate(int n) {
    if (n == 0) {
      return Collections.emptyList();
    }

    List<List<Integer>> rows = new ArrayList<>();
    rows.add(Collections.singletonList(1));

    for (int i = 1; i < n; i++) {
      List<Integer> aboveRow = rows.get(i - 1);
      List<Integer> row = new ArrayList<>();
      row.add(1);
      for (int j = 1; j < i; j++) {
        row.add(aboveRow.get(j - 1) + aboveRow.get(j));
      }
      row.add(1);
      rows.add(row);
    }
    return rows;
  }
}
