package com.willmolloy.hackerrank.interviewpreparationkit.sorting.easy;

import java.util.Arrays;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/mark-and-toys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting>https://www.hackerrank.com/challenges/mark-and-toys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting</a>
 *
 * <p>Runtime: O(n log n)
 *
 * <p>Key idea: Sort the array ahead of time.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class MarkAndToys {

  private MarkAndToys() {}

  static int maximumToys(int[] prices, int k) {
    // sort by lowest price
    Arrays.sort(prices);
    int toyCount = 0;
    // just buy the cheapest toys
    for (int price : prices) {
      if (k >= price) {
        k -= price;
        toyCount += 1;
      } else {
        // early exit
        // the prices are sorted, so if this toy costs too much all the others will by transitivity
        break;
      }
    }
    return toyCount;
  }
}
