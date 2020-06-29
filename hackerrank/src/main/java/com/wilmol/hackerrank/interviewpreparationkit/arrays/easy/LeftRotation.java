package com.wilmol.hackerrank.interviewpreparationkit.arrays.easy;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=arrays>problem
 * link</a>
 *
 * <p>Rotate the array towards the left d times.
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
final class LeftRotation {

  private LeftRotation() {}

  static int[] rotLeft(int[] a, int d) {
    int[] copy = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      copy[i] = a[(i + d) % a.length];
    }
    return copy;
  }
}
