package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a
 * href=https://leetcode.com/problems/maximum-product-of-three-numbers>https://leetcode.com/problems/maximum-product-of-three-numbers</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: heap to track k largest/smallest
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P628MaximumProductOfThreeNumbers {

  public int maximumProduct(int[] nums) {
    // track 3 largest
    // also track 2 smallest, if they're both negative may create a larger product

    // could sort but that'd be slower (O(n log n))

    // min heap
    PriorityQueue<Integer> largest = new PriorityQueue<>();
    // max heap
    PriorityQueue<Integer> smallest = new PriorityQueue<>(Comparator.reverseOrder());

    for (int num : nums) {
      largest.add(num);
      smallest.add(num);
      if (largest.size() > 3) {
        largest.remove();
      }
      if (smallest.size() > 2) {
        smallest.remove();
      }
    }

    // compare
    // 3 largest vs largest and 2 smallest
    int threeLargest = 1;
    while (largest.size() > 1) {
      threeLargest *= largest.remove();
    }
    threeLargest *= largest.peek();
    int largestAndTwoSmallest = 1;
    while (smallest.size() > 1) {
      largestAndTwoSmallest *= smallest.remove();
    }
    largestAndTwoSmallest *= smallest.peek();
    largestAndTwoSmallest *= largest.peek();
    return Math.max(threeLargest, largestAndTwoSmallest);
  }
}
