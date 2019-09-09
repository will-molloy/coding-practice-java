package wilmol.hackerrank.interviewpreparationkit.search.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wilmol on 2019-09-09.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search>https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search</a>
 *
 * <p>Runtime: O(n)
 *
 * @see wilmol.leetcode.problemset.algorithms.easy.P1TwoSum
 */
final class HashTablesIceCreamParlor {

  private static final int[] EMPTY = new int[0];

  private HashTablesIceCreamParlor() {}

  static int[] whatFlavors(int[] costs, int money) {
    // its like 2 sum, index of two costs that add to money
    // note: problem asks for one-index based solution
    // problem also states one unique solution guaranteed
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < costs.length; i++) {
      if (map.containsKey(costs[i])) {
        return new int[] {map.get(costs[i]), i + 1};
      } else {
        map.put(money - costs[i], i + 1);
      }
    }
    return EMPTY;
  }
}
