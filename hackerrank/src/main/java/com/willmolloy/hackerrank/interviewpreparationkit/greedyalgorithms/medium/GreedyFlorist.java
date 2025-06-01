package com.willmolloy.hackerrank.interviewpreparationkit.greedyalgorithms.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/greedy-florist/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms>https://www.hackerrank.com/challenges/greedy-florist/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms</a>
 *
 * <p>Runtime: O(n log n) - must sort?
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class GreedyFlorist {

  private GreedyFlorist() {}

  // k friends buying flowers
  // each additional purchase cost is multiplied by the number of previous purchases plus one
  static int getMinimumCost(int k, int[] flowerPrices) {
    // just buy the most expensive flowers first in sets of size of at most k
    int totalCost = 0;
    int multiplier = 1;
    List<Integer> flowersSortedByPriceDesc =
        Arrays.stream(flowerPrices).boxed().sorted(Comparator.reverseOrder()).toList();
    for (int i = 0; i < flowersSortedByPriceDesc.size(); i += k) {
      int setMultiplier = multiplier;
      int setCost =
          flowersSortedByPriceDesc
              .subList(i, Math.min(i + k, flowersSortedByPriceDesc.size()))
              .stream()
              .mapToInt(a -> a * setMultiplier)
              .sum();
      totalCost += setCost;
      multiplier += 1;
    }
    return totalCost;
  }
}
