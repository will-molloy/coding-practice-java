package com.wilmol.hackerrank.interviewpreparationkit.greedyalgorithms.easy;

import java.util.Arrays;

/**
 * Created by Will on 28/03/2019
 *
 * <p>https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
 *
 * <p>Runtime: O(n log n) -> Must sort ? (Well can avoid sort but then its O(n ^ 2))
 */
class MinimumAbsoluteDifferenceInAnArray {

  static int minimumAbsoluteDifference(int[] arr) {
    Arrays.sort(arr);
    int minDiff = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length - 1 && minDiff != 0; i++) {
      // sorted, so a[i + 1] >= a[i] - no need to do math.abs
      int pairDiff = arr[i + 1] - arr[i];
      minDiff = Math.min(pairDiff, minDiff);
    }
    return minDiff;
  }
}
