package com.willmolloy.leetcode.problemset.algorithms.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/minimum-window-substring>https://leetcode.com/problems/minimum-window-substring</a>
 *
 * <p>Runtime: O(t + s)
 *
 * <p>Space: O(t)
 *
 * <p>Key idea: Hash map to maintain count of characters. Two pointers to 'widen' and 'narrow'
 * window.
 *
 * @see P30SubstringWithConcatenationOfAllWords
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P438FindAllAnagramsInAString
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P567PermutationInString
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P76MinimumWindowSubstring {

  public String minWindow(String s, String t) {

    // count of chars needed to cover 't'
    Map<Character, Integer> counts = new HashMap<>();
    char[] chars = t.toCharArray();
    for (char c : chars) {
      counts.merge(c, 1, Integer::sum);
    }

    int l = 0;
    int r = 0;
    int bestL = 0;
    int bestR = Integer.MAX_VALUE;
    int tCharsCovered = 0;

    while (r <= s.length()) {

      // use counts.size() as that's the number of unique characters in 't'
      if (tCharsCovered == counts.size()) {

        // update best
        if (r - l < bestR - bestL) {
          bestR = r;
          bestL = l;
        }

        // narrow, move l in
        char c = s.charAt(l);
        if (counts.containsKey(c)) { // checks if 'c' is a character we care about (i.e. is in 't')
          counts.put(c, counts.get(c) + 1);
          if (counts.get(c) == 1) {
            tCharsCovered--;
          }
        }
        l++;

      } else if (r < s.length()) {

        // widen, move r out
        char c = s.charAt(r);
        if (counts.containsKey(c)) {
          counts.put(c, counts.get(c) - 1);
          if (counts.get(c) == 0) {
            tCharsCovered++;
          }
        }
        r++;
      } else {

        // needed for final character where:
        // can't move r out because IOOB
        // and can't move l in because 't' not covered
        break;
      }
    }

    return bestR == Integer.MAX_VALUE ? "" : s.substring(bestL, bestR);
  }
}
