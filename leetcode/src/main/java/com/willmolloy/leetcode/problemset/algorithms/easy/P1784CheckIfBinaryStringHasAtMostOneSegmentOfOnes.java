package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones>https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Simulation. Once a one is seen, test if another one is seen after a zero is seen.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1784CheckIfBinaryStringHasAtMostOneSegmentOfOnes {

  public boolean checkOnesSegment(String s) {
    char[] chars = s.toCharArray();

    boolean sawOne = false;
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '1') {
        sawOne = true;
        boolean sawZero = false;
        for (int j = i; j < chars.length; j++) {
          if (chars[j] == '0') {
            sawZero = true;
          }
          if (chars[j] == '1' && sawZero) {
            return false;
          }
        }
        break;
      }
    }
    return sawOne;
  }
}
