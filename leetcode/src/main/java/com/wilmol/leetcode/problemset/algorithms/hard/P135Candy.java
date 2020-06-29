package com.wilmol.leetcode.problemset.algorithms.hard;

import static java.lang.Math.max;

import java.util.Arrays;

/**
 * <a href=https://leetcode.com/problems/candy>https://leetcode.com/problems/candy</a>
 *
 * <p>Runtime: O(2n) - two passes, left to right and right to left
 *
 * @see com.wilmol.hackerrank.interviewpreparationkit.dynamicprogramming.medium.Candies
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P135Candy {

  int candy(int[] scores) {
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
    return (int) Arrays.stream(candies).sum();
  }
}
