package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/consecutive-characters>https://leetcode.com/problems/consecutive-characters/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Two pointers: one to anchor start of sequence, second to reach end.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1446ConsecutiveCharacters {

  public int maxPower(String s) {
    int n = s.length();

    int max = 0;

    for (int start = 0; start < n; start++) {
      int end = start;
      while (end < n - 1 && s.charAt(end) == s.charAt(end + 1)) {
        end++;
      }
      // size of [start, end] = end - start + 1
      max = Math.max(max, end - start + 1);
      start = end;
    }
    return max;
  }
}
