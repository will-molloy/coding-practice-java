package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a
 * href=https://leetcode.com/problems/minimum-domino-rotations-for-equal-row>https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: First figure out which values we could flip to. There are at most 2 of them.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1007MinimumDominoRotationsForEqualRow {

  public int minDominoRotations(int[] a, int[] b) {
    int n = a.length;

    // set to contain possible values we could flip to (i.e. values all dominos have)
    // possible sizes:
    // 0: cannot flip to same value
    // 1: can flip to exactly one value
    // 2: all dominos are same, flipping to either value is same cost
    // >2: impossible (domino has only 2 sides)
    Set<Integer> set = IntStream.rangeClosed(1, 6).boxed().collect(Collectors.toSet());
    for (int i = 0; i < n; i++) {
      set.retainAll(List.of(a[i], b[i]));
    }

    if (set.isEmpty()) {
      return -1;
    }
    // only need first value from set; if set.size() == 2, flipA = flipB and flipB = flipA for other
    // value
    int value = set.iterator().next();
    int flipA = 0;
    int flipB = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] != value) {
        flipA++;
      }
      if (b[i] != value) {
        flipB++;
      }
    }
    return Math.min(flipA, flipB);
  }
}
