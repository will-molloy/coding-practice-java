package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/remove-palindromic-subsequences>https://leetcode.com/problems/remove-palindromic-subsequences/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Removing <b>subsequence</b> - so if not already empty or palindrome can remove all
 * 'a's or 'b's to be left with the other letter which is a palindrome.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1332RemovePalindromicSubsequences {

  public int removePalindromeSub(String s) {
    if (s.isEmpty()) {
      // already empty
      return 0;
    }
    if (isPalindrome(s)) {
      // remove all at once
      return 1;
    }
    // remove either all 'a's or all 'b's then left with palindrome (1 more step)
    return 2;
  }

  private boolean isPalindrome(String s) {
    int l = 0;
    int r = s.length() - 1;
    while (l <= r) {
      if (s.charAt(l) != s.charAt(r)) {
        return false;
      }
      l++;
      r--;
    }
    return true;
  }
}
