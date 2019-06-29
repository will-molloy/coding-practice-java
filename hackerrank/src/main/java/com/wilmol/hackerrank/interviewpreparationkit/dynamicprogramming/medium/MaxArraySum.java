package com.wilmol.hackerrank.interviewpreparationkit.dynamicprogramming.medium;

import static java.lang.Math.max;

import java.util.List;

/**
 * Created by Will on 26/03/2019
 *
 * <p>https://www.hackerrank.com/challenges/max-array-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
 *
 * <p>Find the max subset sum where elements are not adjacent to each other in the original array.
 *
 * <p>DP with 1D array.
 *
 * <p>Runtime: O(n) time O(1) space
 */
final class MaxArraySum {

  private MaxArraySum() {}

  static int maxSubsetSum(List<Integer> list) {
    return maxSubsetSum(list.stream().mapToInt(Integer::intValue).toArray());
  }

  static int maxSubsetSum(int[] arr) {
    // keep track of the maximum at every point (i.e. the sub problems)
    for (int i = 1; i < arr.length; i++) {
      // max at a[0] is a[0] (1st base case)
      if (i == 1) {
        // 2nd base case (i - 2 is still IOOB)
        arr[i] = max(arr[0], arr[1]);
      } else {
        // recursive case
        // max(prev max, this element, this element + prev prev max)
        arr[i] = max(max(arr[i - 1], arr[i]), arr[i] + arr[i - 2]);
      }
    }
    return arr[arr.length - 1];
  }
}
