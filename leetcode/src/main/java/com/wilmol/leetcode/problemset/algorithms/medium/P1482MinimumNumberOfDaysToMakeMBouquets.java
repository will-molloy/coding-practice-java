package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.Arrays;

/**
 * Created by wilmol on 2020-06-14.
 *
 * <p><a
 * href=https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets>https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/</a>
 *
 * <p>Runtime: O(n * log(max(bloomDays)))
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Binary search over the day range.
 */
class P1482MinimumNumberOfDaysToMakeMBouquets {

  public int minDays(int[] bloomDays, int m, int k) {
    int n = bloomDays.length;
    if (n < m * k) {
      return -1;
    }

    int l = 1;
    int r = Arrays.stream(bloomDays).max().getAsInt();
    int min = -1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (isOk(bloomDays, m, k, mid)) {
        // search earlier day (to see if smaller day is ok)
        r = mid - 1;
        min = mid;
      } else {
        // search later day (when more flowers are born)
        l = mid + 1;
      }
    }
    return min;
  }

  private boolean isOk(int[] bloomDays, int m, int k, int day) {
    // flower count
    int count = 0;
    for (int bloomDay : bloomDays) {
      if (bloomDay <= day) {
        count++;
      } else {
        // reset count as flowers must be adjacent
        count = 0;
      }
      if (count == k) {
        // picked k flowers, so need 1 less bouquet
        m--;
        if (m == 0) {
          // picked m bouquets, 'day' is ok
          return true;
        }
        count = 0;
      }
    }
    return false;
  }
}
