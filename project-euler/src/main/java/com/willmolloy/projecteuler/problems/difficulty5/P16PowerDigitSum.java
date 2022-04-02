package com.willmolloy.projecteuler.problems.difficulty5;

import java.math.BigInteger;

/**
 * <a href=https://projecteuler.net/problem=16>https://projecteuler.net/problem=16</a>
 *
 * <p>Runtime: O(b ^ e)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P16PowerDigitSum {

  public int apply(int base, int exp) {
    return BigInteger.valueOf(base)
        .pow(exp)
        .toString()
        .chars()
        .map(Character::getNumericValue)
        .sum();
  }
}
