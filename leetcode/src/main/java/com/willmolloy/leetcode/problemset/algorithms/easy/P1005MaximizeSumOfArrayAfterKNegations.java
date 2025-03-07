package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <a
 * href=https://leetcode.com/problems/maximize-sum-of-array-after-k-negations>https://leetcode.com/problems/maximize-sum-of-array-after-k-negations</a>
 *
 * <p>Key idea: Sort/min heap to get access to smallest values first.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface P1005MaximizeSumOfArrayAfterKNegations {

  int largestSumAfterKNegations(int[] a, int k);

  /**
   * Solution which sorts the input array.
   *
   * <p>Runtime: O(n log n)
   *
   * <p>Space: O(1)
   */
  class Sort implements P1005MaximizeSumOfArrayAfterKNegations {

    @Override
    public int largestSumAfterKNegations(int[] a, int k) {
      // sort array so have access to min elements first
      Arrays.sort(a);

      boolean zero = false;

      // flip as many negatives as allowed
      // (starting with the smallest - i.e. those that produce largest positives)
      int i = 0;
      while (k > 0 && i < a.length && a[i] <= 0) {
        if (a[i] == 0) {
          zero = true;
          break;
        }
        a[i] = -a[i];
        i++;
        k--;
      }

      // if there is a zero, stop (all negatives would've been flipped)
      if (zero) {
        k = 0;
      }

      // if k is > 0 then there are no more negatives or zeros
      // can just flip smallest value once (even number of flips cancel out)
      if (k % 2 != 0) {
        Arrays.sort(a);
        a[0] = -a[0];
      }

      int sum = 0;
      for (int x : a) {
        sum += x;
      }
      return sum;
    }
  }

  /**
   * Solution which dumps the input array into a min heap.
   *
   * <p>Runtime: O(n + k log n)
   *
   * <p>Space: O(n)
   */
  class MinHeap implements P1005MaximizeSumOfArrayAfterKNegations {

    @Override
    public int largestSumAfterKNegations(int[] a, int k) {
      // dump into min heap so have access to min elements first
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      for (int i : a) {
        minHeap.add(i);
      }

      // flip the smallest values first
      // if negative will add back as positive and vice versa
      // (when all negatives are depleted will be repeatedly flipping same value)
      while (k-- > 0) {
        minHeap.add(-minHeap.remove());
      }

      int sum = 0;
      for (int i : minHeap) {
        sum += i;
      }
      return sum;
    }
  }
}
