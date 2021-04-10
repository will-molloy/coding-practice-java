package com.wilmol.leetcode.problemset.algorithms.easy;

import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/determine-if-string-halves-are-alike>https://leetcode.com/problems/determine-if-string-halves-are-alike/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Compare count of vowels in first and second halves of the string.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1704DetermineIfStringHalvesAreAlike {

  private static final Set<Character> VOWELS =
      Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

  public boolean halvesAreAlike(String s) {
    int first = 0;
    int second = 0;
    for (int i = 0; i < s.length(); i++) {
      if (VOWELS.contains(s.charAt(i))) {
        if (i < s.length() / 2) {
          first++;
        } else {
          second++;
        }
      }
    }
    return first == second;
  }
}
