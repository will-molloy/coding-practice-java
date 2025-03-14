package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/rotate-string>https://leetcode.com/problems/rotate-string</a>
 *
 * <p>Runtime: O(n<sup>2</sup>) ({@link String#contains} is O(nm) here we have O(2nn) =
 * O(n<sup>2</sup>))
 *
 * <p>Space: O(n) ({@link String#concat} creates a {@code new} {@link String})
 *
 * <p>Key idea: a rotation of "s" must be a substring of "s" + "s".
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P796RotateString {

  // TODO O(n) time solution

  public boolean rotateString(String a, String b) {
    // let a = xy
    // let b = yx
    // b + b = yxyx = yax
    // a + a = xyxy = xby
    return a.length() == b.length() && (b + b).contains(a);
  }
}
