package com.wilmol.projecteuler.problems.difficulty5;

import java.math.BigInteger;
import java.util.List;

/**
 * <a href=https://projecteuler.net/problem=13>https://projecteuler.net/problem=13</a>
 *
 * <p>Runtime: O(n * m) (addition is linear?)
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P13LargeSum {

  public String apply(List<BigInteger> numbers, int numDigits) {
    return numbers.stream()
        .reduce(BigInteger.valueOf(0), BigInteger::add)
        .toString()
        .substring(0, numDigits);
  }
}
