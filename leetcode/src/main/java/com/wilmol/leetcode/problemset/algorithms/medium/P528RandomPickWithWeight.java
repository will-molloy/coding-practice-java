package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.NavigableMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <a
 * href=https://leetcode.com/problems/random-pick-with-weight>https://leetcode.com/problems/random-pick-with-weight/</a>
 *
 * <p>Key: Represent probability weights with ranges.
 *
 * @see P380InsertDeleteGetRandomO1
 * @see P398RandomPickIndex
 * @see P497RandomPointInNonOverlappingRectangles
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P528RandomPickWithWeight {

  /** Solution class. */
  interface Solution {

    int pickIndex();
  }

  /**
   * {@link Arrays#binarySearch} approach.
   *
   * <p>Runtime: O(n) constructor; O(log n) {@code pickIndex}
   *
   * <p>Extra space: O(n)
   */
  static class BinarySearch implements Solution {

    private final int[] prefixSum;

    BinarySearch(int[] w) {
      int n = w.length;

      // compute cumulative sum (prefix sum)
      // e.g. w = [2, 5, 3] then prefixSum = [2, 7, 10]
      prefixSum = new int[n];
      prefixSum[0] = w[0];
      for (int i = 1; i < n; i++) {
        prefixSum[i] = w[i] + prefixSum[i - 1];
      }
    }

    public int pickIndex() {
      int n = prefixSum.length;
      int bound = prefixSum[n - 1];

      // pick random number in range [0, bound)
      // e.g. w = [2, 5, 3] (prefixSum = [2, 7, 10])
      // pick uniformly random number in range [0, 10)
      // [0, 2) -> 0 (2/10 -> 20% chance)
      // [2, 7) -> 1 (5/10 -> 50% chance)
      // [7, 10) -> 2 (3/10 -> 30% chance)
      // i.e. the weights translate to ranges, which represent the correct probabilities
      // return the index of the range we land in

      // because prefix sum is always sorted binary search can be used
      int target = ThreadLocalRandom.current().nextInt(bound);
      int index = Arrays.binarySearch(prefixSum, target);

      if (index >= 0) {
        // found target (i.e. target was a specific cumulative weight)
        // return next index because its actually the start of the next range (see above)
        return index + 1;
      } else {
        // didn't find target (i.e. target was some value in a range other than the start of a range
        // (other than 0))
        // java.util.Arrays.binarySearch returns -(insertion point) - 1
        // we want this insertion point because this is the index of the range the target lies in
        // (see above)
        // so we need to invert this return value by multiplying by -1 and then adding -1
        // i.e. return value: -i - 1; multiply -1: i + 1; add -1: i
        // this is the same as inverting the bits
        return ~index;
      }
    }
  }

  /**
   * {@link java.util.TreeMap} approach.
   *
   * <p>Runtime: O(n * log(n)) constructor; O(log n) {@code pickIndex}
   *
   * <p>Extra space: O(n)
   */
  static class TreeMap implements Solution {

    private final NavigableMap<Integer, Integer> map;

    private final int bound;

    TreeMap(int[] w) {
      int n = w.length;
      NavigableMap<Integer, Integer> map = new java.util.TreeMap<>();
      int prefixSum = 0;

      for (int i = 0; i < n; i++) {
        prefixSum += w[i];
        map.put(prefixSum, i);
      }

      this.map = Collections.unmodifiableNavigableMap(map);
      this.bound = prefixSum;
    }

    public int pickIndex() {
      return map.higherEntry(ThreadLocalRandom.current().nextInt(bound)).getValue();
    }
  }
}
