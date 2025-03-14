package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/increasing-triplet-subsequence>https://leetcode.com/problems/increasing-triplet-subsequence/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Track min/second min, if a third is found return true.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P334IncreasingTripletSubsequence {

  public boolean increasingTriplet(int[] nums) {
    int min = Integer.MAX_VALUE;
    int secondMin = Integer.MAX_VALUE;
    for (int num : nums) {
      if (num <= min) {
        min = num;
      } else if (num <= secondMin) {
        secondMin = num;
      } else {
        return true;
      }
    }
    return false;
  }
}
