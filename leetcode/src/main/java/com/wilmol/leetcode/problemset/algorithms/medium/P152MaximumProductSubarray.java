package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.stream.IntStream;

/**
 * <a
 * href=https://leetcode.com/problems/maximum-product-subarray>https://leetcode.com/problems/maximum-product-subarray</a>
 *
 * <p>Key: math knowledge (in particular, products)
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
interface P152MaximumProductSubarray {

  int maxProduct(int[] nums);

  /**
   * Quadratic time solution, still passed leetcode submission.
   *
   * <p>Runtime: O(n<sup>2</sup>)
   *
   * <p>Space: O(1)
   */
  class Quadratic implements P152MaximumProductSubarray {

    @Override
    public int maxProduct(int[] nums) {
      // simply try all the contiguous sub-arrays
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < nums.length; i++) {
        int product = 1;
        for (int j = i; j < nums.length; j++) {
          product *= nums[j];
          max = Math.max(max, product);
        }
      }
      return max;
    }
  }

  /**
   * Linear time solution.
   *
   * <p>Runtime: O(n)
   *
   * <p>Space: O(1)
   */
  class Linear implements P152MaximumProductSubarray {

    // based on
    // https://leetcode.com/problems/maximum-product-subarray/discuss/48330/Simple-Java-code

    @Override
    public int maxProduct(int[] nums) {
      // each iteration, track max/min value from the previous product
      // (this is NOT the global max/min, these are local (contiguous to current location) max/min)
      int prevMax = nums[0];
      int prevMin = nums[0];
      int globalMax = nums[0];
      for (int i = 1; i < nums.length; i++) {
        // compare: extending prevMax, extending prevMin (since negative * negative is a positive),
        // and also starting again with nums[i] (since that is also a product)
        int newMax = max(prevMax * nums[i], prevMin * nums[i], nums[i]);
        int newMin = min(prevMax * nums[i], prevMin * nums[i], nums[i]);
        globalMax = Math.max(globalMax, newMax);
        prevMax = newMax;
        prevMin = newMin;
      }
      return globalMax;
    }

    private int max(int... ints) {
      return IntStream.of(ints).max().getAsInt();
    }

    private int min(int... ints) {
      return IntStream.of(ints).min().getAsInt();
    }
  }
}
