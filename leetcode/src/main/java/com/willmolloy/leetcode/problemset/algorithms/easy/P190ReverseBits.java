package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/reverse-bits>https://leetcode.com/problems/reverse-bits/</a>
 *
 * <p>Runtime: O(1)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Converting to unsigned, if negative add 2<sup>32</sup> (see {@link
 * Integer#toUnsignedLong}). When reversing, have to pad with zeros, so iterate all 32 bits.
 *
 * @see P461HammingDistance
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P190ReverseBits {

  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    // to unsigned
    long longN;
    if (n < 0) {
      longN = (long) Math.pow(2, 32) + n;
    } else {
      longN = n;
    }

    // to binary
    StringBuilder binary = new StringBuilder();
    for (int i = 0; i < 32; i++) {
      binary.append(longN % 2);
      longN /= 2;
    }

    // to integer (traversing binary in reverse)
    int result = 0;
    int exp = 0;
    for (int i = 31; i >= 0; i--) {
      if (binary.charAt(i) == '1') {
        result += (1 << exp);
      }
      exp++;
    }
    return result;
  }
}
