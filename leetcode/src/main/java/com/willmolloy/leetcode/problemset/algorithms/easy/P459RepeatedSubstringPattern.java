package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/repeated-substring-pattern>https://leetcode.com/problems/repeated-substring-pattern/</a>
 *
 * <p>Runtime: O(n<sup>2</sup>) TODO smaller? Outer is O(n). Inner is O(n) amortised, but doesn't
 * always execute.
 *
 * <p>Extra memory: O(n) (substring creates new string - worst case has size n/2)
 *
 * <p>Key idea: Brute force.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P459RepeatedSubstringPattern {

  public boolean repeatedSubstringPattern(String s) {
    // try
    // [0, n/2] * 2
    // [0, n/3] * 3
    // ..
    // [0, n/n] * n
    // no reason to try [>0, x] since must repeat from start
    // can't try any larger than [0, n/2] (repeated string length would exceed n)

    int n = s.length();
    for (int subLen = n / 2; subLen >= 1; subLen--) {
      if (n % subLen != 0) {
        continue;
      }
      if (isOk(subLen, s)) {
        return true;
      }
    }
    return false;
  }

  private boolean isOk(int subLen, String s) {
    int n = s.length();
    for (int i = subLen; i < n; i += subLen) {
      if (!s.substring(i, i + subLen).equals(s.substring(0, subLen))) {
        return false;
      }
    }
    return true;
  }
}
