package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2020-06-08.
 *
 * <p><a
 * href=https://leetcode.com/problems/squares-of-a-sorted-array>https://leetcode.com/problems/squares-of-a-sorted-array/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Array is partitioned into negative half and positive half; negative half squares are
 * arranged in descending order while positive half squares are arranged in ascending order. So
 * having two pointers (one for each half) is optimal.
 */
class P977SquaresOfASortedArray {

  public int[] sortedSquares(int[] a) {
    int n = a.length;

    // two pointers, one for positive numbers, one for negative numbers
    int positiveI = 0;
    // find where negative becomes positive
    while (positiveI < n && a[positiveI] < 0) {
      positiveI++;
    }
    int negativeI = positiveI - 1;

    int i = 0;
    int[] result = new int[n];
    // since positive half squares are arranged in ascending order, increase positive index pointer
    // since negative half squares are arranged in descending order, decrease negative index pointer
    while (positiveI < n && negativeI >= 0) {
      if (a[negativeI] * a[negativeI] < a[positiveI] * a[positiveI]) {
        result[i++] = a[negativeI] * a[negativeI];
        negativeI--;
      } else {
        result[i++] = a[positiveI] * a[positiveI];
        positiveI++;
      }
    }
    while (positiveI < n) {
      result[i++] = a[positiveI] * a[positiveI];
      positiveI++;
    }
    while (negativeI >= 0) {
      result[i++] = a[negativeI] * a[negativeI];
      negativeI--;
    }

    return result;
  }
}
