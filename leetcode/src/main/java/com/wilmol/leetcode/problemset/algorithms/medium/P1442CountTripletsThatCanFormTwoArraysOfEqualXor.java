package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2020-05-10.
 *
 * <p><a
 * href=https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor>https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/</a>
 *
 * <p>Runtime: O(n<sup>3</sup>)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: {@code a} doesn't depend on {@code k} so can compute and store it for some {@code i} and
 * {@code j} and then compute all {@code b}s; reducing complexity from O(n<sup>4</sup>) to
 * O(n<sup>3</sup>).
 */
class P1442CountTripletsThatCanFormTwoArraysOfEqualXor {

  public int countTriplets(int[] arr) {
    int n = arr.length;
    int count = 0;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int a = arr[i];
        for (int z = i + 1; z <= j - 1; z++) {
          a ^= arr[z];
        }

        int b = arr[j];
        if (a == b) {
          count++;
        }
        for (int k = j + 1; k < n; k++) {
          b ^= arr[k];
          if (a == b) {
            count++;
          }
        }
      }
    }
    return count;
  }
}
