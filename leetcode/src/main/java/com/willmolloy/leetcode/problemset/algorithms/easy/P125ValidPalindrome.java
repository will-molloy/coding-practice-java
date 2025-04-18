package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.Locale;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://leetcode.com/problems/valid-palindrome>https://leetcode.com/problems/valid-palindrome</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key idea: 2 pointers
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P125ValidPalindrome {

  private static final Pattern NON_ALPHANUMERIC = Pattern.compile("[^a-zA-Z\\d]");

  public boolean isPalindrome(String s) {
    s = NON_ALPHANUMERIC.matcher(s).replaceAll("").toLowerCase(Locale.ENGLISH);
    int l = 0;
    int r = s.length() - 1;
    while (l <= r) {
      if (s.charAt(l++) != s.charAt(r--)) {
        return false;
      }
    }
    return true;
  }
}
