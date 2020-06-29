package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away>https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Not sure why the problem description shows gaps between all 1s; the answer only depends
 * on gaps between adjacent 1s (so only need to track most recent 1 in a single pass solution).
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1437CheckIfAll1sAreAtLeastKPlacesAway {

  public boolean kLengthApart(int[] nums, int k) {
    if (nums.length == 0) {
      return true;
    }

    int prev1 = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        if (prev1 == -1) {
          prev1 = i;
        } else {
          int dist = i - prev1 - 1;
          if (dist < k) {
            return false;
          }
          prev1 = i;
        }
      }
    }
    return true;
  }
}
