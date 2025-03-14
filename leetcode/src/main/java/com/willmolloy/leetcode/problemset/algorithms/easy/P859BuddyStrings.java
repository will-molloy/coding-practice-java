package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/buddy-strings>https://leetcode.com/problems/buddy-strings/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Consider the two cases:
 *
 * <ol>
 *   <li>a == b, then need to swap a duplicate character
 *   <li>a != b, then need exactly two characters out of place to swap
 * </ol>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P859BuddyStrings {

  public boolean buddyStrings(String a, String b) {
    if (a.length() != b.length()) {
      return false;
    }
    int n = a.length();

    if (a.equals(b)) {
      // need dupe char to swap
      int[] freq = new int[26];
      for (char c : a.toCharArray()) {
        freq[c - 'a']++;
        if (freq[c - 'a'] == 2) {
          return true;
        }
      }
      return false;
    }

    // need exactly two characters out of place to swap
    int first = -1;
    int second = -1;
    for (int i = 0; i < n; i++) {
      if (a.charAt(i) != b.charAt(i)) {
        if (first == -1) {
          first = i;
        } else if (second == -1) {
          second = i;
        } else {
          // 3rd difference
          return false;
        }
      }
    }
    return first != -1
        && second != -1
        && a.charAt(first) == b.charAt(second)
        && a.charAt(second) == b.charAt(first);
  }
}
