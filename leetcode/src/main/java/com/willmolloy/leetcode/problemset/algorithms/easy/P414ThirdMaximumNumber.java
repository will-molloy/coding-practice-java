package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/third-maximum-number>https://leetcode.com/problems/third-maximum-number/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(n)
 *
 * <p>Key idea: Priority queue (heap) to track the 3 maximums. Place smallest at top of heap so it's
 * removed first.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P347TopKFrequentElements
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P692TopKFrequentWords
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P973KClosestPointsToOrigin
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P414ThirdMaximumNumber {

  public int thirdMax(int[] nums) {
    Set<Integer> distinctNums = new HashSet<>();
    for (int i : nums) {
      distinctNums.add(i);
    }

    PriorityQueue<Integer> heap = new PriorityQueue<>();
    for (int i : distinctNums) {
      heap.add(i);
      if (heap.size() > 3) {
        heap.remove();
      }
    }

    if (heap.size() < 3) {
      // if < 3 distinct nums then return the maximum (silly requirement)
      while (heap.size() > 1) {
        heap.remove();
      }
    }
    return heap.peek();
  }
}
