package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters>https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/</a>
 *
 * <p>Runtime: O(n<sup>2</sup>)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Brute force - search all substring lengths. Sliding window to determine if a length is
 * ok.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P395LongestSubstringWithAtLeastKRepeatingCharacters {

  // TODO inefficient solution - still AC

  public int longestSubstring(String s, int k) {
    int n = s.length();

    // search all substring lengths
    for (int size = n; size >= 1; size--) {
      if (isOk(s, k, size)) {
        // stop at first as its longest
        return size;
      }
    }
    // empty string is always valid
    return 0;
  }

  // O(n)
  private boolean isOk(String s, int k, int size) {
    int n = s.length();

    int[] freq = new int[26];

    // sliding window of all substrings with length 'size'
    for (int i = 0; i < n; i++) {
      freq[s.charAt(i) - 'a']++;
      if (i >= size - 1) {
        // TODO streams times out here
        // O(26) = O(1)
        boolean all = true;
        for (int f : freq) {
          if (f != 0 && f < k) {
            all = false;
            break;
          }
        }
        if (all) {
          return true;
        }
        freq[s.charAt(i - size + 1) - 'a']--;
      }
    }
    return false;
  }
}
