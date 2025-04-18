package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters>https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: Brute force; find first valid replacement [a, z].
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1576ReplaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters {

  public String modifyString(String s) {
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '?') {
        for (char c = 'a'; c <= 'z'; c++) {
          if ((i == 0 || chars[i - 1] != c) && (i == chars.length - 1 || chars[i + 1] != c)) {
            chars[i] = c;
            break;
          }
        }
      }
    }
    return new String(chars);
  }
}
