package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2020-04-23.
 *
 * <p><a
 * href=https://leetcode.com/problems/bitwise-and-of-numbers-range>https://leetcode.com/problems/bitwise-and-of-numbers-range/</a>
 *
 * <p>Difficulty: Medium.
 *
 * <p>Runtime: O(min(bitlen(m), bitlen(n)))
 *
 * <p>Space: O(1)
 *
 * <p>Key: Using bitwise operations (here, shifts) given it is a bitwise operator problem (hint!).
 */
class P201BitwiseAndOfNumbersRange {

  public int rangeBitwiseAnd(int m, int n) {
    int mask = 1;
    // keep shifting m and n right until equal
    // this means it will stop when a common prefix of 1s is found
    // this works because with bitwise AND if there is at least one 0 the result is 0
    while (m != n) {
      m >>= 1;
      n >>= 1;
      // this tracks how many bits to keep at the end
      mask <<= 1;
    }
    // m == n at this point
    return m * mask;
  }
}
