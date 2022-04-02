package com.willmolloy.hackerrank.interviewpreparationkit.dynamicprogramming.medium;

import static java.lang.Math.max;

import java.util.Arrays;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/candies/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming>https://www.hackerrank.com/challenges/candies/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming</a>
 *
 * <p>Minimum candies required such that all kids get candies and kid with higher score than their
 * neighbours gets more than that neighbour (note: if they have same score and neighbours they could
 * have different amount of candies).
 *
 * <p>Runtime: O(2n)
 *
 * <p>Can be done in one pass -> <a
 * href=https://leetcode.com/articles/candy>https://leetcode.com/articles/candy</a>
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P135Candy
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
public final class Candies {

  private Candies() {}

  static long candies(int[] scores) {
    if (scores.length <= 1) {
      return scores.length;
    }

    long[] candies = new long[scores.length];

    // left to right - give default amount (1) and more if score > left neighbour
    // cannot check right neighbour yet because the candy is not distributed
    candies[0] = 1;
    for (int i = 1; i < scores.length; i++) {
      if (scores[i] > scores[i - 1]) {
        // child scored more than their left neighbour
        candies[i] = candies[i - 1] + 1;
      } else {
        // every child gets at least one candy
        candies[i] = 1;
      }
    }

    // right to left - check if any scores > right neighbour
    for (int i = scores.length - 1; i > 0; i--) {
      if (scores[i - 1] > scores[i]) {
        // child scored more than their right neighbour
        candies[i - 1] = max(candies[i - 1], candies[i] + 1);
      }
    }
    return Arrays.stream(candies).sum();
  }
}
