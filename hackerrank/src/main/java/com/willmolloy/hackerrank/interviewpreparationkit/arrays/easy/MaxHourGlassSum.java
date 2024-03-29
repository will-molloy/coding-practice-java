package com.willmolloy.hackerrank.interviewpreparationkit.arrays.easy;

import static java.lang.Math.max;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays>https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays</a>
 *
 * <p>Find the sum of the hour glass with the maximum sum.
 *
 * <p>Runtime: O(n * m)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class MaxHourGlassSum {

  private MaxHourGlassSum() {}

  static int hourglassSum(int[][] arr) {
    int maxSum = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length - 2; i++) {
      for (int j = 0; j < arr[i].length - 2; j++) {
        int sum = hourglassSum(arr, i, j);
        maxSum = max(maxSum, sum);
      }
    }
    return maxSum;
  }

  private static int hourglassSum(int[][] arr, int startI, int startJ) {
    int sum = 0;
    for (int i = startI; i < startI + 3; i++) {
      for (int j = startJ; j < startJ + 3; j++) {
        if (i == startI + 1 && (j == startJ || j == startJ + 2)) {
          // the absence of these two elements form the 'hourglass' shape
          continue;
        }
        sum += arr[i][j];
      }
    }
    return sum;
  }
}
