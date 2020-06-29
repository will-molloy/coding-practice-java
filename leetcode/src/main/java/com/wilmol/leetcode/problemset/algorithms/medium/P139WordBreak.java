package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <a href=https://leetcode.com/problems/word-break>https://leetcode.com/problems/word-break</a>
 *
 * <p>Key: dynamic programming
 *
 * @see com.wilmol.leetcode.problemset.algorithms.hard.P140WordBreak2
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
interface P139WordBreak {

  boolean wordBreak(String s, List<String> wordDict);

  /**
   * Top down solution; TLE on leetcode.
   *
   * <p>Runtime: TODO O() idk lol; the brute force on leetcode doesn't loop over 'wordDict' instead
   * it uses a set, so this is even worse
   *
   * <p>Space: O(n) (n = size of 's'; determines the recursion depth)
   */
  class TopDown implements P139WordBreak {

    @Override
    public boolean wordBreak(String s, List<String> wordDict) {
      if (s.isEmpty()) {
        return true;
      }
      for (String word : wordDict) {
        Pattern p = Pattern.compile(word + "(.*)");
        Matcher m = p.matcher(s);
        if (m.matches() && wordBreak(m.group(1), wordDict)) {
          return true;
        }
      }
      return false;
    }
  }

  /**
   * Bottom up solution.
   *
   * <p>Runtime: O(n<sup>2</sup>) (n = size of 's')
   *
   * <p>Space: O(n) (n = size of 's'; 1d dp array size)
   */
  class BottomUp implements P139WordBreak {

    @Override
    public boolean wordBreak(String s, List<String> wordDict) {
      return wordBreak(s, new HashSet<>(wordDict));
    }

    private boolean wordBreak(String s, HashSet<String> words) {
      // dp[i] means we can build the string s.substring(0, i);
      boolean[] dp = new boolean[s.length() + 1];

      // base case, can always build empty string
      dp[0] = true;

      // check if whole string can be built
      for (int i = 1; i <= s.length(); i++) {
        // find word which can build
        for (int j = 0; j < i; j++) {
          if (dp[j] && words.contains(s.substring(j, i))) {
            dp[i] = true;
            break;
          }
        }
      }
      return dp[s.length()];
    }
  }
}
