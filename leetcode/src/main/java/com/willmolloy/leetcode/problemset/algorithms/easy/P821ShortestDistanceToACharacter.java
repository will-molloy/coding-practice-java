package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/shortest-distance-to-a-character>https://leetcode.com/problems/shortest-distance-to-a-character/</a>
 *
 * <p>Difficulty: Easy.
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n) (O(1) excluding returned array... but it is mutated).
 *
 * <p>Key idea: Two passes; one forward and one backward.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P821ShortestDistanceToACharacter {

  public int[] shortestToChar(String s, char c) {
    // 2 passes one forward one reverse

    // forward case, fill and count ahead of 0s:
    // [n, n, n, 0, 1, 0, 0, 1, 2, 3, 4, 0]
    // backward case, count behind 0s (taking min):
    // [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]

    int n = s.length();
    int[] a = new int[n];

    // forward case
    int count = n;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == c) {
        count = 0;
      }
      a[i] = Math.min(n, count);
      count++;
    }

    // backward case
    count = n;
    for (int i = n - 1; i >= 0; i--) {
      if (s.charAt(i) == c) {
        count = 0;
      }
      a[i] = Math.min(a[i], count);
      count++;
    }
    return a;
  }
}
