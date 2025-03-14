package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a href=https://leetcode.com/problems/ransom-note>https://leetcode.com/problems/ransom-note/</a>
 *
 * <p>Runtime: O(ransomNote + magazine)
 *
 * <p>Extra space: O(1) (fixed sized array used)
 *
 * <p>Key idea: Count frequency of letters.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P383RansomNote {

  public boolean canConstruct(String ransomNote, String magazine) {
    int[] letters = new int[26];
    for (char c : magazine.toCharArray()) {
      letters[c - 'a']++;
    }

    for (char c : ransomNote.toCharArray()) {
      letters[c - 'a']--;
      if (letters[c - 'a'] < 0) {
        return false;
      }
    }
    return true;
  }
}
