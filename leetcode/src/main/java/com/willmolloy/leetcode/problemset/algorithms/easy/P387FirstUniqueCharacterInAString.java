package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/first-unique-character-in-a-string>https://leetcode.com/problems/first-unique-character-in-a-string/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key idea: It is the <b>index</b> of the <b>first</b> unique character. Not the character. Not
 * any unique character.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P387FirstUniqueCharacterInAString {

  public int firstUniqChar(String s) {
    int[] counts = new int[26];
    for (char c : s.toCharArray()) {
      counts[c - 'a']++;
    }

    for (int i = 0; i < s.length(); i++) {
      if (counts[s.charAt(i) - 'a'] == 1) {
        return i;
      }
    }
    return -1;
  }
}
