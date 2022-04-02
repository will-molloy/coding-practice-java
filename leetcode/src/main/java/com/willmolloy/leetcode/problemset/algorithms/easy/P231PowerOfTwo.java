package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/power-of-two>https://leetcode.com/problems/power-of-two/</a>
 *
 * <p>Difficulty: Easy.
 *
 * <p>Key: Power of two has one '1' bit (which is the MSB).
 *
 * @see P342PowerOfFour
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface P231PowerOfTwo {

  boolean isPowerOfTwo(int n);

  /**
   * LibraryMethod.
   *
   * <p>Runtime: O(bitlen(n))
   *
   * <p>Space: O(1)
   */
  class LibraryMethod implements P231PowerOfTwo {

    @Override
    public boolean isPowerOfTwo(int n) {
      // simply check count of 1 bits is 1
      return n > 0 && Integer.bitCount(n) == 1;
    }
  }

  /**
   * BitManipulation.
   *
   * <p>Runtime: O(bitlen(n))
   *
   * <p>Space: O(1)
   */
  class BitManipulation implements P231PowerOfTwo {

    @Override
    public boolean isPowerOfTwo(int n) {
      // ANDing with n-1 will give 0 if n is a power of 2 because all the bits will cancel out
      // e.g.
      //   n = 16 = 10000b
      // n-1 = 15 = 01111b
      // n&(n-1) = 00000b = 0
      return n > 0 && (n & (n - 1)) == 0;
    }
  }

  /**
   * Recursive.
   *
   * <p>Runtime: O(log(n))
   *
   * <p>Space: O(log(n))
   */
  class Recursive implements P231PowerOfTwo {

    @Override
    public boolean isPowerOfTwo(int n) {
      // check all trailing bits are 0s until n is reduced to 1
      return n == 1 || n > 0 && n % 2 == 0 && isPowerOfTwo(n / 2);
    }
  }

  /**
   * Iterative.
   *
   * <p>Runtime: O(log(n))
   *
   * <p>Space: O(1)
   */
  class Iterative implements P231PowerOfTwo {

    @Override
    public boolean isPowerOfTwo(int n) {
      // same procedure as recursive solution, just done with a loop
      while (n > 1) {
        if (n % 2 != 0) {
          return false;
        }
        n /= 2;
      }
      return n == 1;
    }
  }
}
