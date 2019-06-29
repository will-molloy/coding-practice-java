package com.wilmol.hackerrank.interviewpreparationkit.greedyalgorithms.easy;

import java.util.PriorityQueue;

/**
 * Created by Will on 28/03/2019
 *
 * <p>https://www.hackerrank.com/challenges/luck-balance/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
 *
 * <p>Would have preferred to 'win' as many contests as possible, why would you want to lose?
 *
 * <p>Runtime: O(n log k) with O(k) extra space
 */
final class LuckBalance {

  private LuckBalance() {}

  // want to lose as many contests as possible (to maximise the luck balance)
  // options: sort the array descending and take first k elements or keep track of top 'k' elements
  // via min heap
  static int luckBalance(int k, int[][] contests) {
    int luckBalance = 0;
    // min heap, the head will be the smallest of the top 'k' important contests
    PriorityQueue<Integer> topKImportantContests = new PriorityQueue<>();

    for (int[] contest : contests) {
      int luckFactor = contest[0];
      boolean important = contest[1] == 1;
      if (!important) {
        // lose all unimportant contests
        luckBalance += luckFactor;
      } else if (topKImportantContests.size() < k) {
        // lose only the top 'k' important contests
        luckBalance += luckFactor;
        topKImportantContests.add(luckFactor);
      } else if (!topKImportantContests.isEmpty() && luckFactor > topKImportantContests.peek()) {
        luckBalance -= 2 * topKImportantContests.poll();
        luckBalance += luckFactor;
        topKImportantContests.add(luckFactor);
      } else {
        luckBalance -= luckFactor;
      }
    }
    return luckBalance;
  }
}
