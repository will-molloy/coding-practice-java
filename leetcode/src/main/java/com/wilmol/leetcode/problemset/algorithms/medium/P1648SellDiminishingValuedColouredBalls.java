package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.TreeMap;

/**
 * <a
 * href=https://leetcode.com/problems/sell-diminishing-valued-colored-balls>https://leetcode.com/problems/sell-diminishing-valued-colored-balls/</a>
 *
 * <p>Runtime: O(n * log(n))
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Sell max value first. Sell batches down to next maximum.
 *
 * <p>Remember {@code long} to avoid {@code int} overflow. {@code long} can fit {@code
 * INT_MAX}<sup>2</sup>.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1648SellDiminishingValuedColouredBalls {

  private static final int MOD = (int) 1e9 + 7;

  public int maxProfit(int[] inventory, int orders) {
    // construct treemap - n log n
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int i : inventory) {
      map.merge(i, 1, Integer::sum);
    }

    // fulfill orders - n log n
    long sum = 0;
    while (orders > 0 && !map.isEmpty()) {
      int max = map.lastKey();
      int amtMax = map.lastEntry().getValue();
      // 2nd max
      int max2 = map.size() > 1 ? map.lowerKey(max) : 0;
      // size of (max2, max]
      int size = (max - max2) * amtMax;

      if (orders >= size) {
        // take all max down to max2
        // sell (max2, max] * amtMax
        sum += sum(max2 + 1, max) * amtMax;
        // all max became max2
        map.remove(max);
        if (max2 > 0) {
          map.merge(max2, amtMax, Integer::sum);
        }
      } else {
        // take partial max
        // orders = q * amtMax + r
        int q = orders / amtMax;
        int r = orders % amtMax;
        // sell (max - q, max] * amtMax
        sum += sum(max - q + 1, max) * amtMax;
        // sell [max - q] * r
        sum += (long) (max - q) * r;
      }
      orders = Math.max(orders - size, 0);
      sum %= MOD;
    }
    return (int) sum;
  }

  // sums [l, r]
  private long sum(long l, long r) {
    return (r - l + 1) * (l + r) / 2;
  }
}
