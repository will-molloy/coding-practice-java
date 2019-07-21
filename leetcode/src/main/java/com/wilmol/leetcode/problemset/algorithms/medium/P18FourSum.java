package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Will on 2019-07-21 at 16:13.
 *
 * <p><a href=https://leetcode.com/problems/4sum>https://leetcode.com/problems/4sum</a>
 *
 * <p>Runtime: O(n ^ 3)
 *
 * @see P15ThreeSum
 */
class P18FourSum {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    if (nums.length < 4) {
      return Collections.emptyList();
    }

    Arrays.sort(nums);
    // cheating to use a set... should skip over duplicates manually
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < nums.length - 3; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue; // skip duplicates (except for first occurrence)
      }
      for (int j = i + 1; j < nums.length - 2; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue; // skip duplicates (except for first occurrence)
        }
        int k = j + 1;
        int l = nums.length - 1;
        while (k < l) {
          int sum = nums[i] + nums[j] + nums[k] + nums[l];
          if (sum == target) {
            result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
            k += 1;
            l -= 1;
            while (k < l && nums[k - 1] == nums[k]) {
              k += 1; // skip duplicates
            }
            while (k < l && nums[l + 1] == nums[l]) {
              l -= 1; // skip duplicates
            }
          } else if (sum < target) {
            k += 1; // sum too small
          } else {
            l -= 1; // sum too large
          }
        }
      }
    }
    return result;
  }
}
