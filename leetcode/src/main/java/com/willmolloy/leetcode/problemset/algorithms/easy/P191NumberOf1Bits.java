package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/number-of-1-bits>https://leetcode.com/problems/number-of-1-bits/</a>
 *
 * <p>Difficulty: Easy.
 *
 * <p>Runtime: O(bitlen(n))
 *
 * <p>Space: O(1)
 *
 * <p>Key idea: {@link Integer#bitCount} method.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P191NumberOf1Bits {

  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    return Integer.bitCount(n);
  }
}
