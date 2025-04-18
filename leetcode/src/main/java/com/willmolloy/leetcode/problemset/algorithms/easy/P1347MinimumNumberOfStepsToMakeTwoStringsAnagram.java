package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram>https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram</a>
 *
 * <p>Runtime: O(s + t)
 *
 * <p>Space: O(1)
 *
 * <p>Key idea: counting frequencies
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1347MinimumNumberOfStepsToMakeTwoStringsAnagram {

  // preconditions:
  // s.length = t.length
  // s and t match "[a-z]"

  public int minSteps(String s, String t) {
    // O(s)
    int[] sFreqs = charFreqs(s);
    // O(t)
    int[] tFreqs = charFreqs(t);

    // O(1)
    int steps = 0;
    for (char c = 'a'; c <= 'z'; c++) {
      int sFreq = sFreqs[index(c)];
      int tFreq = tFreqs[index(c)];
      // only care about steps to change "t" into "s"
      // hence if larger freq in "t", take zero, cause those characters will already be counted when
      // looking at the smaller freqs (they'd be converted to cover those smaller freq characters)
      // (this is the same as taking sum of abs differences and dividing by 2)
      steps += Math.max(0, sFreq - tFreq);
    }
    return steps;
  }

  private int[] charFreqs(String s) {
    int[] map = new int[26];
    for (char c : s.toCharArray()) {
      map[index(c)] += 1;
    }
    return map;
  }

  private int index(char c) {
    return c - 'a';
  }
}
