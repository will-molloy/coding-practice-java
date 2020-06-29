package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/longest-palindromic-subsequence>https://leetcode.com/problems/longest-palindromic-subsequence/</a>
 *
 * <p>Difficulty: Medium.
 *
 * <p>Runtime: O(n<sup>2</sup>)
 *
 * <p>Space: O(n<sup>2</sup>)
 *
 * <p>Key: When the palindrome can't be extended then {@code dp[l][r] = max(dp[l + 1][r], dp[l][r -
 * 1])} because both subsequences (remove first/remove last) need to be considered.
 *
 * @see P5LongestPalindromicSubstring
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P516LongestPalindromicSubsequence {

  public int longestPalindromeSubseq(String s) {
    if (s.isEmpty()) {
      return 0;
    }

    int n = s.length();

    // dp[l][r] = length of longest palindrome subseq considering s[l, r] (s.substring(l, r + 1))
    int[][] dp = new int[n][n];

    // s[l, r] is palindrome if s[l] == s[r] && s[l + 1, r - 1] is palindrome (recursive)
    // or s[l] == s[r] && s[l, r].length <= 2 (base)

    // try all r >= l
    // need to decrement l so l + 1 is computed first
    // and increment r so r - 1 is computed first
    for (int l = n - 1; l >= 0; l--) {
      for (int r = l; r < n; r++) {
        int length = r - l + 1;
        if (s.charAt(l) == s.charAt(r)) {
          if (length <= 2) {
            // base case, <= 2 equal characters must be palindrome
            dp[l][r] = length;
          } else {
            // recursive case, able to extend palindrome with 2 equal characters
            dp[l][r] = dp[l + 1][r - 1] + 2;
          }
        } else {
          // recursive case, unable to extend palindrome, take best so far
          // (compare removing first/last)
          dp[l][r] = Math.max(dp[l + 1][r], dp[l][r - 1]);
        }
      }
    }
    return dp[0][n - 1];
  }
}
