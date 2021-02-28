package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers>https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Each step multiply number by length of new number and add new number.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1680ConcatenationOfConsecutiveBinaryNumbers {

  private static final int MOD = 1_000_000_007;

  public int concatenatedBinary(int n) {
    long sum = 0;
    for (int i = 1; i <= n; i++) {
      String binary = Integer.toBinaryString(i);
      sum = (sum * (int) Math.pow(2, binary.length()) + i) % MOD;
    }
    return (int) sum;
  }
}
