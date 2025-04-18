package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/implement-strstr>https://leetcode.com/problems/implement-strstr</a>
 *
 * <p>Runtime: O(n * m) (haystack length = n, needle length = m)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P28ImplementStrStr {

  public int strStr(String haystack, String needle) {
    // return 0 if empty string (problem description)
    if (needle.isEmpty()) {
      return 0;
    }

    char[] haystackChars = haystack.toCharArray(); // performance optimisation

    // try each char as starting value
    for (int i = 0; i < haystackChars.length; i++) {

      // check rest of haystack can fit needle
      if (needle.length() > haystackChars.length - i) {
        return -1;
      }

      // check needle matches, given current index as starting point
      int j = 0;
      while (j < needle.length() && needle.charAt(j) == haystackChars[i + j]) {
        j += 1;
      }
      if (j == needle.length()) {
        return i;
      }
    }
    return -1;
  }
}
