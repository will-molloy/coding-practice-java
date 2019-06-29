package com.wilmol.hackerrank.interviewpreparationkit.arrays.easy;

/**
 * Created by Will on 24/03/2019
 *
 * <p>https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=arrays
 * Rotate the array towards the left d times.
 *
 * <p>Runtime: O(n)
 */
class LeftRotation {

  static int[] rotLeft(int[] a, int d) {
    int[] copy = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      copy[i] = a[(i + d) % a.length];
    }
    return copy;
  }
}
