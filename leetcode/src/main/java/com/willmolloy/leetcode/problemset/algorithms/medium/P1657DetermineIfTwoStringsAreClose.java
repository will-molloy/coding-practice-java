package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/determine-if-two-strings-are-close>https://leetcode.com/problems/determine-if-two-strings-are-close/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1) - fixed number of keys (at most 26)
 *
 * <p>Key: Test key/value sets are equal (separately):
 *
 * <ul>
 *   <li>Can use operation 1 to swap characters - position doesn't matter - can compare sets rather
 *       than seqs
 *   <li>Can use operation 2 to transform characters - aka swap character frequency values - as long
 *       as the key/value sets are equal the values can be assigned to the keys such that the
 *       mappings (key -> value) are equal
 * </ul>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1657DetermineIfTwoStringsAreClose {

  public boolean closeStrings(String word1, String word2) {
    Map<Character, Integer> charFreqs1 = charFreqs(word1);
    Map<Character, Integer> charFreqs2 = charFreqs(word2);

    return charFreqs1.keySet().equals(charFreqs2.keySet())
        && Set.copyOf(charFreqs1.values()).equals(Set.copyOf(charFreqs2.values()));
  }

  private Map<Character, Integer> charFreqs(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.merge(c, 1, Integer::sum);
    }
    return map;
  }
}
