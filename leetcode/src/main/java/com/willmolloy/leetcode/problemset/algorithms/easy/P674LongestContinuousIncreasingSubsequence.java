package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/longest-continuous-increasing-subsequence>https://leetcode.com/problems/longest-continuous-increasing-subsequence</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key idea: Once we have a sequence, never need to change the starting point (since we want the
 * longest sequence), only see if the end point can be progressed. If the end point cannot progress
 * then can simply start over, as all previous elements are 'blocked' from entering the new
 * sequence. In other words, all continuous increasing subsequences are <b>disjoint</b>.
 *
 * @see
 *     com.willmolloy.leetcode.problemset.algorithms.medium.P673NumberOfLongestIncreasingSubsequence
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P674LongestContinuousIncreasingSubsequence {

  public int findLengthOfLcis(int[] nums) {
    // as soon as seq is broken, restart it, cant take earlier elements anyway
    if (nums.length == 0) {
      return 0;
    }
    int max = 1;
    int length = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) {
        length += 1;
        max = Math.max(max, length);
      } else {
        length = 1;
      }
    }
    return max;
  }
}
