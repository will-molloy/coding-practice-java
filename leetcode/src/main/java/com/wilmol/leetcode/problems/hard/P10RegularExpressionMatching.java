package com.wilmol.leetcode.problems.hard;

/**
 * Created by Will on 2019-07-15 at 19:41.
 *
 * <p><a
 * href=https://leetcode.com/problems/regular-expression-matching>https://leetcode.com/problems/regular-expression-matching</a>
 *
 * <p>Runtime: ???
 */
class P10RegularExpressionMatching {

  public boolean isMatch(String s, String p) {
    if (s == null || p == null) {
      return false;
    }
    return s.matches(p);
  }
}
