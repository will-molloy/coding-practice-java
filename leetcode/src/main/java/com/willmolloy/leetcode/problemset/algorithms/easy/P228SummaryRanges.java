package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/summary-ranges>https://leetcode.com/problems/summary-ranges/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Inner while loop to build a range each iteration.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P228SummaryRanges {

  public List<String> summaryRanges(int[] nums) {
    int n = nums.length;

    List<String> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int start = nums[i];
      while (i + 1 < n && nums[i] + 1 == nums[i + 1]) {
        i++;
      }
      int end = nums[i];

      if (start == end) {
        list.add(Integer.toString(start));
      } else {
        list.add(String.format("%d->%d", start, end));
      }
    }
    return list;
  }
}
