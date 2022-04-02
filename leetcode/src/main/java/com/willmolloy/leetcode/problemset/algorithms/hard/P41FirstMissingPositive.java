package com.willmolloy.leetcode.problemset.algorithms.hard;

/**
 * <a
 * href=https://leetcode.com/problems/first-missing-positive>https://leetcode.com/problems/first-missing-positive</a>
 *
 * <p>Runtime: O(n), O(1) extra memory (TODO does decrementing index break O(n)??)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P41FirstMissingPositive {

  public int firstMissingPositive(int[] nums) {
    // first pass: swap positive values to their position ('sort' them for this problem)
    // i.e. index 0 = 1, index 1 = 2...
    // works because there is at most 'n' positive values, dont care about smaller or larger values
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (num > 0 && num < nums.length && i != num - 1) {
        swap(nums, num - 1, i);
        // may have swapped an element out of position, so decrement the index to check it
        // (check not same value else infinite loop)
        if (nums[num - 1] != nums[i]) {
          i -= 1;
        }
      }
    }

    // second pass: return first missing value, trivial now that nums is 'sorted'
    int missing = 1;
    for (int num : nums) {
      if (missing != num) {
        break;
      }
      missing += 1;
    }
    return missing;
  }

  private static void swap(int[] x, int a, int b) {
    int t = x[a];
    x[a] = x[b];
    x[b] = t;
  }
}
