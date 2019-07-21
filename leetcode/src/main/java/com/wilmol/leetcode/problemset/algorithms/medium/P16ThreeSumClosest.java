package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.Arrays;

/**
 * Created by Will on 2019-07-21 at 14:31.
 *
 * <p><a
 * href=https://leetcode.com/problems/3sum-closest>https://leetcode.com/problems/3sum-closest</a>
 *
 * <p>Runtime: O(n ^ 2)
 *
 * @see P15ThreeSum
 */
class P16ThreeSumClosest {

  public int threeSumClosest(final int[] nums, final int target) {
    if (nums.length < 3) {
      return Arrays.stream(nums).sum();
    }
    // sort first
    Arrays.sort(nums);

    // TODO optimise by skipping over dupes?
    int closestSum = nums[0] + nums[1] + nums[2];
    for (int i = 0; i < nums.length - 2; i++) {
      int j = i + 1;
      int k = nums.length - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == target) {
          return target;
        }
        if (isCloser(target, closestSum, sum)) {
          closestSum = sum;
        }
        if (sum < target) {
          j += 1; // sum too small, try larger numbers
        } else {
          k -= 1; // sum too large, try smaller numbers
        }
      }
    }
    return closestSum;
  }

  private boolean isCloser(int target, int oldSum, int newSum) {
    return Math.abs(target - newSum) < Math.abs(target - oldSum);
  }
}
