package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array>https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key idea: Got the hint you use a[i]-1 as an index (since a[i]:[1, n]) but was marking with 0s,
 * really needed to mark with negative numbers.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P448FindAllNumbersDisappearedInAnArray {

  public List<Integer> findDisappearedNumbers(int[] a) {
    // since a[i] fits into [1, n] can use it as an index
    // i.e. make a[a[i] - 1] negative if a[i] is present
    for (int i = 0; i < a.length; i++) {
      // make a[a[i] - 1] negative (rather than marking it with '0' or '-1' etc.) because we may
      // need to use an element which was previously marked (when array is not in ascending order)
      int num = Math.abs(a[i]) - 1;
      a[num] = -Math.abs(a[num]);
    }

    List<Integer> list = new ArrayList<>();
    for (int num = 1; num <= a.length; num++) {
      int i = num - 1;
      if (a[i] > 0) {
        list.add(num);
      }
    }
    return list;
  }
}
