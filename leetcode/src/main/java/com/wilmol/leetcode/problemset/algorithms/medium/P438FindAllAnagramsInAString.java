package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/find-all-anagrams-in-a-string>https://leetcode.com/problems/find-all-anagrams-in-a-string/</a>
 *
 * <p>Difficulty: Medium.
 *
 * <p>Runtime: O(p + s)
 *
 * <p>Space: O(1) (fixed sized array used)
 *
 * <p>Key: With the sliding window, don't recompute the entire {@code freqs} array rather remove the
 * start of the old window and add the end of the new window.
 *
 * @see com.wilmol.leetcode.problemset.algorithms.hard.P76MinimumWindowSubstring
 * @see P567PermutationInString
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P438FindAllAnagramsInAString {

  public List<Integer> findAnagrams(String s, String p) {
    if (p.length() > s.length()) {
      return Collections.emptyList();
    }

    List<Integer> result = new ArrayList<>();

    // track char freq balance for p (required) and window of size p over s (used)
    int[] freqs = new int[26];
    // overall balance (avoids need to frequently check array sums to 0)
    int balance = 0;

    // initialise by adding required characters
    for (char c : p.toCharArray()) {
      int cI = c - 'a';
      freqs[cI]++;
      if (freqs[cI] == 1) {
        // 'c' is now required
        balance++;
      }
    }

    // initial window starting at index 0
    for (int i = 0; i < p.length(); i++) {
      int cI = s.charAt(i) - 'a';
      freqs[cI]--;
      if (freqs[cI] == 0) {
        // 's.charAt(i)' is now covered
        balance--;
      }
    }
    if (balance == 0) {
      result.add(0);
    }

    // perform sliding window for starting indices [1, s - p]
    for (int i = 1; i <= s.length() - p.length(); i++) {
      // remove start of old window
      int startCharI = s.charAt(i - 1) - 'a';
      freqs[startCharI]++;
      if (freqs[startCharI] == 1) {
        balance++;
      }

      // add end of new window
      int endCharI = s.charAt(i + p.length() - 1) - 'a';
      freqs[endCharI]--;
      if (freqs[endCharI] == 0) {
        balance--;
      }

      if (balance == 0) {
        result.add(i);
      }
    }

    return result;
  }
}
