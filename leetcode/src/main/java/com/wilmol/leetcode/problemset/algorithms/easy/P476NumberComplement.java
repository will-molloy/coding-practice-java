package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2020-05-04.
 *
 * <p><a
 * href=https://leetcode.com/problems/number-complement>https://leetcode.com/problems/number-complement/</a>
 *
 * <p>Runtime: O(bitLength(num))
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Converting decimal to binary; you get the bits (from the remainders) in reverse order.
 *
 * @see P1009ComplementOfBase10Integer
 */
class P476NumberComplement {

  public int findComplement(int num) {
    int res = 0;
    int exp = 0;
    while (num > 0) {
      int bit = num % 2;
      // flip
      bit = bit == 1 ? 0 : 1;

      res += bit << exp;

      num /= 2;
      exp++;
    }
    return res;
  }
}
