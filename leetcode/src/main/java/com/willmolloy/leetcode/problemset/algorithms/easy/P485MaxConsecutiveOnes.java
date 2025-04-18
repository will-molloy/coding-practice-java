package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/max-consecutive-ones>https://leetcode.com/problems/max-consecutive-ones/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key idea: The runs of 1s are disjoint so can reset {@code current} and update {@code max} when
 * they end.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P485MaxConsecutiveOnes {

  public int findMaxConsecutiveOnes(int[] nums) {
    int max = 0;
    int current = 0;
    for (int i : nums) {
      if (i == 0) {
        max = Math.max(max, current);
        current = 0;
      } else {
        current++;
      }
    }
    return Math.max(max, current);
  }
}
