package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/find-the-difference>https://leetcode.com/problems/find-the-difference/</a>
 *
 * <p>Runtime: O({@code s} + {@code t}) = O({@code t})
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Set difference of letters in {@code s} and {@code t}.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P389FindTheDifference {

  public char findTheDifference(String s, String t) {
    int[] freq = new int[26];
    for (char c : t.toCharArray()) {
      freq[c - 'a']++;
    }
    for (char c : s.toCharArray()) {
      freq[c - 'a']--;
    }

    for (char c = 'a'; c <= 'z'; c++) {
      if (freq[c - 'a'] == 1) {
        return c;
      }
    }

    throw new IllegalArgumentException();
  }
}
