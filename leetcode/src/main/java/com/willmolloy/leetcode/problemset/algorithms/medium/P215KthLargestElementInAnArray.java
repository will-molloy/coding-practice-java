package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.PriorityQueue;

/**
 * <a
 * href=https://leetcode.com/problems/kth-largest-element-in-an-array>https://leetcode.com/problems/kth-largest-element-in-an-array/</a>
 *
 * <p>Runtime: O(n * log(k)) TODO O(n) is possible (quick select)
 *
 * <p>Extra memory: O(k)
 *
 * <p>Key: Maintain k largest elements in a min heap. At the end, head of heap must be the kth
 * largest overall.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P215KthLargestElementInAnArray {

  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int num : nums) {
      minHeap.add(num);
      if (minHeap.size() > k) {
        minHeap.remove();
      }
    }
    return minHeap.peek();
  }
}
