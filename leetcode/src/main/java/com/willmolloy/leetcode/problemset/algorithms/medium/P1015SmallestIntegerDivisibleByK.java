package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/smallest-integer-divisible-by-k>https://leetcode.com/problems/smallest-integer-divisible-by-k/</a>
 *
 * <p>Runtime: O(k)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Need to store remainders modulo k to avoid overflow.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1015SmallestIntegerDivisibleByK {

  public int smallestRepunitDivByK(int k) {
    int r = 0;
    for (int len = 1; len <= k; len++) {
      r = (r * 10 + 1) % k;
      if (r == 0) {
        return len;
      }
    }
    return -1;
  }
}
