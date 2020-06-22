package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2020-05-03.
 *
 * <p><a
 * href=https://leetcode.com/problems/ransom-note>https://leetcode.com/problems/ransom-note/</a>
 *
 * <p>Runtime: O(ransomNote + magazine)
 *
 * <p>Extra space: O(1) (fixed sized array used)
 *
 * <p>Key: Count frequency of letters.
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
