package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href=https://leetcode.com/problems/decode-ways>https://leetcode.com/problems/decode-ways</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key idea: dynamic programming
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface P91DecodeWays {

  int numDecodings(String s);

  /** Top down approach, uses memoization to pass time limit. */
  class TopDownWithMemoize implements P91DecodeWays {

    @Override
    public int numDecodings(String s) {
      return solve(s, new HashMap<>());
    }

    private int solve(String s, Map<String, Integer> cache) {
      if (cache.containsKey(s)) {
        return cache.get(s);
      }

      // base cases
      if (s.isEmpty() || s.charAt(0) == '0') {
        // zero ways to decode empty string or a '0' (valid range is '1' to '26')
        return 0;
      }
      if (s.length() == 1) {
        // must be '1' to '9', 1 way
        return 1;
      }
      if (s.length() == 2) {
        int i = Integer.parseInt(s);
        int numWays = 0;
        if (i <= 26) {
          // additional way for valid 2 character encoding
          numWays += 1;
        }
        if (s.charAt(1) != '0') {
          // additional way for valid 2 x 1 character encoding (i.e. doesn't have a '0')
          numWays += 1;
        }
        return numWays;
      }

      // recursive cases
      int numWays = 0;
      String withoutFirst = s.substring(1);
      numWays += solve(withoutFirst, cache);

      String firstTwo = s.substring(0, 2);
      if (Integer.parseInt(firstTwo) <= 26) {
        String withoutFirstTwo = s.substring(2);
        numWays += solve(withoutFirstTwo, cache);
      }

      cache.put(s, numWays);
      return numWays;
    }
  }

  /** Bottom up approach. */
  class BottomUpDp implements P91DecodeWays {

    @Override
    public int numDecodings(String s) {
      if (s.isEmpty()) {
        return 0;
      }

      // create 1d dp
      int[] dp = new int[s.length() + 1];
      dp[0] = 1;
      dp[1] = s.charAt(0) != '0' ? 1 : 0;

      for (int i = 2; i <= s.length(); i++) {
        int first = Integer.parseInt(s.substring(i - 1, i));
        int second = Integer.parseInt(s.substring(i - 2, i));
        if (first != 0) {
          dp[i] += dp[i - 1];
        }
        if (second >= 10 && second <= 26) {
          dp[i] += dp[i - 2];
        }
      }
      return dp[s.length()];
    }
  }
}
