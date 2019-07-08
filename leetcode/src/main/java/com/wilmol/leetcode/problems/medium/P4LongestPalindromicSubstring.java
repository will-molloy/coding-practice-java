package com.wilmol.leetcode.problems.medium;

import java.util.stream.IntStream;

/**
 * Created by Will on 2019-07-08 at 19:50.
 *
 * <p><a
 * href=https://leetcode.com/problems/longest-palindromic-substring>https://leetcode.com/problems/longest-palindromic-substring</a>
 *
 * <p>Runtime: O(n ^ 2)
 */
class P4LongestPalindromicSubstring {

  private static final String EMPTY_STRING = "";

  public String longestPalindrome(String s) {
    // brute force!
    // do sliding window of each possible size at each possible starting position... until
    // palindrome is found
    // start with maximum window size such that first palindrome found is maximum size (for an early
    // exit)
    // TODO improvement? identify where palindrome fails, check either side of that character ???
    for (int size = s.length(); size > 0; size--) {
      for (int start = 0; start <= s.length() - size; start++) {
        String substring = s.substring(start, start + size);
        if (isPalindrome(substring)) {
          return substring;
        }
      }
    }
    // no substring palindrome found, except for the empty string
    return EMPTY_STRING;
  }

  private boolean isPalindrome(String s) {
    return IntStream.rangeClosed(0, s.length() / 2)
        .allMatch(i -> s.charAt(i) == s.charAt(s.length() - i - 1));
  }
}
