package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/find-all-duplicates-in-an-array>https://leetcode.com/problems/find-all-duplicates-in-an-array/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Mark {@code num} seen by making {@code nums[num]} negative. Works since {@code num}
 * is in [1, n], so each has a bucket.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P645SetMismatch
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P442FindAllDuplicatesInAnArray {

  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      // abs since other num may have made it negative
      int num = Math.abs(nums[i]);
      // num is in [1, n] so need 1-indexed
      int index = num - 1;

      if (nums[index] < 0) {
        // if already negative, must be dupe
        result.add(num);
      } else {
        // make negative to mark as seen
        nums[index] = -nums[index];
      }
    }

    return result;
  }
}
