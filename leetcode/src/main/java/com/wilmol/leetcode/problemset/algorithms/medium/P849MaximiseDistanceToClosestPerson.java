package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/maximize-distance-to-closest-person>https://leetcode.com/problems/maximize-distance-to-closest-person/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Maximum distance from a seat is in the middle of the seats furthest apart. Also compare
 * sitting in first/last seat.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P849MaximiseDistanceToClosestPerson {

  public int maxDistToClosest(int[] seats) {
    int n = seats.length;

    int max = 0;
    int i = 0;

    // first seat
    for (; i < n; i++) {
      if (seats[i] == 1) {
        max = i;
        break;
      }
    }

    // between seats
    int prev = max;
    for (; i < n; i++) {
      if (seats[i] == 1) {
        // sit in middle of (prev, i) (+1 to range size so it rounds up)
        int size = i - prev;
        max = Math.max(max, size / 2);
        prev = i;
      }
    }

    // last seat
    max = Math.max(max, n - 1 - prev);

    return max;
  }
}
