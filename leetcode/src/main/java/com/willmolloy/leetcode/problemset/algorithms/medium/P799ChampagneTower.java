package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/champagne-tower>https://leetcode.com/problems/champagne-tower/</a>
 *
 * <p>Runtime: O({@code queryRow}<sup>2</sup>)
 *
 * <p>Extra memory: O({@code queryRow}<sup>2</sup>)
 *
 * <p>Key idea: Track total amount poured through each glass, this way can process all pours in one
 * go.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P799ChampagneTower {

  public double champagneTower(int poured, int queryRow, int queryGlass) {
    // lists[row][col] = total amount poured through that glass
    List<List<Double>> lists = new ArrayList<>();
    for (int row = 0; row <= queryRow; row++) {
      lists.add(new ArrayList<>(Collections.nCopies(row + 1, 0d)));
    }

    lists.get(0).set(0, (double) poured);

    // loop until queryRow since we set amount in next row
    for (int row = 0; row < queryRow; row++) {
      for (int col = 0; col <= row; col++) {
        double spilled = lists.get(row).get(col) - 1;
        if (spilled > 0) {
          // spill into left and right
          lists.get(row + 1).set(col, lists.get(row + 1).get(col) + spilled / 2);
          lists.get(row + 1).set(col + 1, lists.get(row + 1).get(col + 1) + spilled / 2);
        }
      }
    }
    return Math.min(lists.get(queryRow).get(queryGlass), 1);
  }
}
