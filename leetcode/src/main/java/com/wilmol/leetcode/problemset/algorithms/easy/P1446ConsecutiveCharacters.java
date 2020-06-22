package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2020-05-17.
 *
 * <p><a
 * href=https://leetcode.com/problems/consecutive-characters>https://leetcode.com/problems/consecutive-characters/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Two pointers: one to anchor start of sequence, second to reach end.
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
