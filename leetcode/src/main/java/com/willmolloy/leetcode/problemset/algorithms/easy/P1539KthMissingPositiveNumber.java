package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/kth-missing-positive-number>https://leetcode.com/problems/kth-missing-positive-number/</a>
 *
 * <p>Runtime: O(n) TODO log(n) binary search is possible
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Track next positive number while scanning the array.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1539KthMissingPositiveNumber {

  public int findKthPositive(int[] arr, int k) {
    int next = 1;
    int count = 0;
    int i = 0;

    while (true) {
      while (i == arr.length || next != arr[i]) {
        count++;
        if (count == k) {
          return next;
        }
        next++;
      }
      next++;
      i++;
    }
  }
}
