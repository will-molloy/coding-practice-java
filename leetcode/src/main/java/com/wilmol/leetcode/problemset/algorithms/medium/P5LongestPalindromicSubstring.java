package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/longest-palindromic-substring>https://leetcode.com/problems/longest-palindromic-substring/</a>
 *
 * <p>Difficulty: Medium.
 *
 * <p>Runtime: O(n<sup>2</sup>)
 *
 * <p>Space: O(n<sup>2</sup>)
 *
 * <p>Key: Dp formula is {@code dp[l][r] = s[l] == s[r] && dp[l + 1][r - 1]} therefore need to loop
 * {@code l} in reverse order so {@code l + 1} is computed first.
 *
 * @see P516LongestPalindromicSubsequence
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P5LongestPalindromicSubstring {

  public String longestPalindrome(String s) {
    if (s.isEmpty()) {
      return "";
    }

    int n = s.length();

    // dp[l][r] = true if s[l, r] is a palindrome
    boolean[][] dp = new boolean[n][n];

    int longestLength = 0;
    int bestL = 0;
    int bestR = 0;

    // loop in this order because dp[l][r] depends on dp[l + 1][r - 1]
    // (i.e. l must decrement so larger values are populated first)
    for (int l = n - 1; l >= 0; l--) {
      // r must be >= l for final substring to work, so no reason to start from 0
      for (int r = l; r < n; r++) {
        // recursive case:
        // can extend if outer chars are equal and inner string (dp[l + 1][r - l]) is palindrome
        // this also covers the base case (length <= 2)
        int length = r - l + 1;
        if ((length <= 2 || dp[l + 1][r - 1]) && s.charAt(l) == s.charAt(r)) {
          dp[l][r] = true;
          if (length > longestLength) {
            longestLength = length;
            bestL = l;
            bestR = r;
          }
        }
      }
    }
    return s.substring(bestL, bestR + 1);
  }
}
