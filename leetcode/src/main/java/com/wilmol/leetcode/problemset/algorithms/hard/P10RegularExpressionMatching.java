package com.wilmol.leetcode.problemset.algorithms.hard;

/**
 * <a
 * href=https://leetcode.com/problems/regular-expression-matching>https://leetcode.com/problems/regular-expression-matching</a>
 *
 * <p>Runtime: TODO O()
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P10RegularExpressionMatching {

  public boolean isMatch(String s, String p) {
    return s != null && p != null && s.matches(p);
  }
}
