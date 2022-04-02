package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Collections;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <a
 * href=https://leetcode.com/problems/random-point-in-non-overlapping-rectangles>https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/</a>
 *
 * <p>Runtime: O(n * log(n)) {@code Solution} constructor; O(log n) {@code pick}
 *
 * <p>Extra space: O(n)
 *
 * <p>Key: Pick random rectangle with weight (see {@link P528RandomPickWithWeight} for more details
 * on how this works) then pick point uniformly at random in that rectangle.
 *
 * @see P380InsertDeleteGetRandomO1
 * @see P398RandomPickIndex
 * @see P528RandomPickWithWeight
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P497RandomPointInNonOverlappingRectangles {

  /** Solution class. */
  static class Solution {

    private final NavigableMap<Integer, int[]> map;

    private final int bound;

    Solution(int[][] rects) {
      // rectangle weight is its area (i.e. number of points)
      // use area prefix sum as map key
      // so map keyset will look like:
      // [0, a1, a1+a2, a1+a2+a3, ...]

      TreeMap<Integer, int[]> map = new TreeMap<>();
      int areaPrefixSum = 0;

      for (int[] rect : rects) {
        int width = rect[2] - rect[0] + 1;
        int height = rect[3] - rect[1] + 1;
        int area = width * height;
        areaPrefixSum += area;
        map.put(areaPrefixSum, rect);
      }

      this.map = Collections.unmodifiableNavigableMap(map);
      this.bound = areaPrefixSum;
    }

    public int[] pick() {
      // pick random rectangle by picking random number in the range:
      // [0, bound), where bound = a1 + a2 + a3 + ... an
      // and taking next highest entry
      // so if picking in range [0, a1) get rect1 for example
      // this shows the rectangles are weighted by their area
      int[] rect = map.higherEntry(ThreadLocalRandom.current().nextInt(bound)).getValue();

      // pick random point in rectangle
      int x = ThreadLocalRandom.current().nextInt(rect[0], rect[2] + 1);
      int y = ThreadLocalRandom.current().nextInt(rect[1], rect[3] + 1);

      return new int[] {x, y};
    }
  }
}
