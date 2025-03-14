package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Arrays;

/**
 * <a
 * href=https://leetcode.com/problems/magnetic-force-between-two-balls>https://leetcode.com/problems/magnetic-force-between-two-balls/</a>
 *
 * <p>Runtime: O(n * log(n) + n * log(max(positions))) = O(n * log(max(positions)))
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Binary search. Essentially have an array partitioned into true (can place balls x
 * distance apart) and false (can't place balls x distance apart) ([true, true, ..., false, false])
 * want the last true.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P278FirstBadVersion
 * @see P1283FindTheSmallestDivisorGivenAThreshold
 * @see P1482MinimumNumberOfDaysToMakeMBouquets
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1552MagneticForceBetweenTwoBalls {

  // will always be enough baskets, so worst case return 1

  public int maxDistance(int[] positions, int m) {
    int n = positions.length;
    Arrays.sort(positions);

    // searching [l, r]
    int l = 0;
    int r = positions[n - 1];
    int result = 0;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (isOk(positions, m, mid)) {
        result = mid;
        // search (mid, r] (see if larger min dist exists)
        l = mid + 1;
      } else {
        // search [l, mid) (couldn't place m balls, need smaller distance)
        r = mid - 1;
      }
    }
    return result;
  }

  // true if can place m balls minDist apart
  private boolean isOk(int[] positions, int m, int minDist) {
    int n = positions.length;
    int ballsPlaced = 1;
    int prevPosition = positions[0];
    for (int i = 1; i < n; i++) {
      if (positions[i] - prevPosition >= minDist) {
        prevPosition = positions[i];
        ballsPlaced++;
      }
    }
    return ballsPlaced >= m;
  }
}
