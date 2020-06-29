package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping>https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/</a>
 *
 * <p>Difficulty: Easy.
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key: Greedy, look ahead for '#' since it must be processed.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1309DecryptStringFromAlphabetToIntegerMapping {

  public String freqAlphabets(String s) {
    int n = s.length();
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < n; ) {
      if (i < n - 2 && s.charAt(i + 2) == '#') {
        int val = Integer.parseInt(s.substring(i, i + 2)); // exclude '#'
        char c = (char) (val + 'a' - 1);
        builder.append(c);
        i += 3;
      } else {
        int val = Character.digit(s.charAt(i), 10);
        char c = (char) (val + 'a' - 1);
        builder.append(c);
        i++;
      }
    }
    return builder.toString();
  }
}
