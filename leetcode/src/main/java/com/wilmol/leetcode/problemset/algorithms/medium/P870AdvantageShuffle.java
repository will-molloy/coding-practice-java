package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * <a
 * href=https://leetcode.com/problems/advantage-shuffle>https://leetcode.com/problems/advantage-shuffle/</a>
 *
 * <p>Runtime: O(n * log(n))
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Greedy. Take smallest {@code a[i]} greater than {@code b[i]} so remaining {@code a[i]}
 * have higher chance of beating a {@code b[i]}.
 *
 * <p>Done by sorting first so smallest {@code a[i]} compare with smallest {@code b[i]} initially,
 * then if an {@code a[i]} can't beat a {@code b[i]} we know it won't beat any {@code b[i]} so can
 * be 'unused'.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P870AdvantageShuffle {

  public int[] advantageCount(int[] a, int[] unsortedB) {
    int n = a.length;
    Arrays.sort(a);
    int[] b = unsortedB.clone();
    Arrays.sort(b);

    // example 1 (after sorting):
    // b = [1, 4, 10, 11]
    // a = [2, 7, 11, 15]
    // advantage = 4 (perfect score)
    // but need original order...

    // example 2 (after sorting):
    // b = [11, 13, 25, 32]
    // a = [8, 12, 24, 32]
    // really want:
    // a = [12, 24, 32, 8]
    // i.e. 8 is useless, place it at the end

    Map<Integer, Queue<Integer>> used = new HashMap<>();
    Queue<Integer> unused = new ArrayDeque<>();

    int ai = 0;
    int bi = 0;
    while (ai < n && bi < n) {
      if (a[ai] > b[bi]) {
        used.computeIfAbsent(b[bi], k -> new ArrayDeque<>()).add(a[ai]);
        ai++;
        bi++;
      } else {
        unused.add(a[ai]);
        ai++;
      }
    }

    // construct result with correct order (i.e. of unsorted b)
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      if (used.containsKey(unsortedB[i])) {
        result[i] = used.get(unsortedB[i]).remove();
        if (used.get(unsortedB[i]).isEmpty()) {
          used.remove(unsortedB[i]);
        }
      } else {
        result[i] = unused.remove();
      }
    }
    return result;
  }
}
