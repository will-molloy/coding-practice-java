package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/product-of-array-except-self>https://leetcode.com/problems/product-of-array-except-self</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key idea: Prefix sums.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P238ProductOfArrayExceptSelf {

  public int[] productExceptSelf(int[] nums) {
    // prefixProduct[i] = product(nums[0, i))
    int[] prefixProduct = new int[nums.length];
    prefixProduct[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
    }

    // suffixProduct[i] = product(nums(i, n))
    int[] suffixProduct = new int[nums.length];
    suffixProduct[nums.length - 1] = 1;
    for (int i = nums.length - 2; i >= 0; i--) {
      suffixProduct[i] = suffixProduct[i + 1] * nums[i + 1];
    }

    int[] output = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      // we want product(nums[0, n)) excluding i
      // which is product(nums[0, i)) * product(nums(i, n))
      output[i] = prefixProduct[i] * suffixProduct[i];
    }
    return output;
  }
}
