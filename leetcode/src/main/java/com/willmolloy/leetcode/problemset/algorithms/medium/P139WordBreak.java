package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.List;

/**
 * <a href=https://leetcode.com/problems/word-break>https://leetcode.com/problems/word-break</a>
 *
 * <p>Key: dynamic programming
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P140WordBreak2
 */
interface P139WordBreak {

  boolean wordBreak(String s, List<String> wordDict);

  /**
   * Top down solution; TLE on leetcode.
   *
   * <p>Runtime: O({@code s}<sup>{@code wordDict}</sup>)
   *
   * <p>Space: O({@code s}) (recursion depth)
   */
  class TopDown implements P139WordBreak {

    @Override
    public boolean wordBreak(String s, List<String> wordDict) {
      if (s.isEmpty()) {
        // base case, can always build empty string
        return true;
      }

      // recursive case, try all words as prefixes and test if suffix can be built recursively
      for (String prefix : wordDict) {
        if (s.startsWith(prefix)) {
          String suffix = s.substring(prefix.length());
          if (wordBreak(suffix, wordDict)) {
            return true;
          }
        }
      }
      return false;
    }
  }

  /**
   * Bottom up solution.
   *
   * <p>Runtime: O({@code s} * {@code wordDict})
   *
   * <p>Space: O({@code s}) (dp table size)
   */
  class BottomUp implements P139WordBreak {

    @Override
    public boolean wordBreak(String s, List<String> wordDict) {
      int n = s.length();

      // dp[i] = can build s[0, i)
      boolean[] dp = new boolean[n + 1];
      // base case, can always build empty string
      dp[0] = true;

      // recursive case, extend known prefixes with every word
      for (int i = 0; i <= n; i++) {
        if (dp[i]) {
          for (String word : wordDict) {
            if (word.length() + i <= n && word.equals(s.substring(i, i + word.length()))) {
              dp[i + word.length()] = true;
            }
          }
        }
      }
      return dp[n];
    }
  }
}
