package com.wilmol.hackerrank.interviewpreparationkit.greedyalgorithms.medium;

import java.util.Arrays;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/angry-children/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms>https://www.hackerrank.com/challenges/angry-children/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms</a>
 *
 * <p>Find subset of size k from arr such that max(subset) - min(subset) is minimised
 *
 * <p>Runtime: O(n log n) - sort first
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
final class MaxMinUnfairness {

  private MaxMinUnfairness() {}

  static int maxMin(int k, int[] arr) {
    // sort the arr
    // do sliding window -> min = [i], max = a[i + k - 1]
    // contains minimum (max - min)
    Arrays.sort(arr);
    int best = Integer.MAX_VALUE;
    for (int i = 0; i <= arr.length - k && best != 0; i++) {
      int min = arr[i];
      int max = arr[i + k - 1];
      best = Math.min(max - min, best);
    }
    return best;
  }
}
