package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/longest-word-in-dictionary-through-deleting>https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/</a>
 *
 * <p>Runtime: O(d * x) - where d is {@code d.size()} and x is average string size in {@code d}
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Test each string in the dictionary is a subsequence.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P524LongestWordInDictionaryThroughDeleting {

  public String findLongestWord(String b, List<String> d) {
    String max = "";
    for (String a : d) {
      if ((a.length() > max.length() || a.length() == max.length() && a.compareTo(max) < 0)
          && isSubsequence(a, b)) {
        max = a;
      }
    }
    return max;
  }

  // O(a + b) = O(a) since a.length() <= b.length()
  private boolean isSubsequence(String a, String b) {
    if (a.length() > b.length()) {
      return false;
    }
    int ai = 0;
    int bi = 0;

    while (ai < a.length() && bi < b.length()) {
      if (a.charAt(ai) == b.charAt(bi)) {
        ai++;
      }
      bi++;
    }
    return ai == a.length();
  }
}
