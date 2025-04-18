package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/palindromic-substrings>https://leetcode.com/problems/palindromic-substrings/</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
sealed interface P647PalindromicSubstrings {

  int countSubstrings(String s);

  /**
   * Bruce force solution - tests all substrings for palindrome.
   *
   * <p>Runtime: O(n<sup>3</sup>)
   *
   * <p>Extra memory: O(1)
   *
   * <p>Key idea: Sliding window for all substring sizes [1, n].
   */
  final class TestAllSubstrings implements P647PalindromicSubstrings {

    @Override
    public int countSubstrings(String s) {
      int n = s.length();

      int count = 0;
      for (int substringSize = 1; substringSize <= n; substringSize++) {
        for (int i = 0; i <= n - substringSize; i++) {
          if (isPalindrome(s, i, i + substringSize - 1)) {
            count++;
          }
        }
      }
      return count;
    }

    private boolean isPalindrome(String s, int l, int r) {
      while (l < r) {
        if (s.charAt(l) != s.charAt(r)) {
          return false;
        }
        l++;
        r--;
      }
      return true;
    }
  }

  /**
   * Dynamic programming solution.
   *
   * <p>Runtime: O(n<sup>2</sup>)
   *
   * <p>Extra memory: O(n<sup>2</sup>)
   *
   * <p>Key idea: {@code boolean dp[l][r]} represents the substring {@code s[l, r]} is a palindrome.
   *
   * <p>Base case: single letter and double letter palindromes.
   *
   * <p>Recursive case: {@code dp[l][r] = dp[l + 1][r - 1] AND s[l] == s[r]}.
   */
  final class Dp implements P647PalindromicSubstrings {

    @Override
    public int countSubstrings(String s) {
      int n = s.length();

      int count = 0;

      // dp[l][r] represents:
      // the substring s[l, r] is a palindrome
      boolean[][] dp = new boolean[n][n];

      // base cases:
      // single letter palindromes (i.e. s[i, i])
      for (int i = 0; i < n; i++) {
        dp[i][i] = true;
        count++;
      }
      // double letter palindromes (i.e. s[i, i + 1] where s[i] == s[i + 1])
      for (int i = 0; i < n - 1; i++) {
        if (s.charAt(i) == s.charAt(i + 1)) {
          dp[i][i + 1] = true;
          count++;
        }
      }
      // need both base cases:
      // first for odd length palindromes and second for even length palindromes

      // recursive case:
      // dp[l][r] = dp[l + 1][r - 1] AND s[l] == s[r]
      // i.e. extending a palindrome with the same letter on both sides is a palindrome
      for (int substringSize = 3; substringSize <= n; substringSize++) {
        int l = 0;
        int r = l + substringSize - 1;
        while (r < n) {
          if (dp[l + 1][r - 1] && s.charAt(l) == s.charAt(r)) {
            dp[l][r] = true;
            count++;
          }
          l++;
          r++;
        }
      }
      return count;
    }
  }
}
