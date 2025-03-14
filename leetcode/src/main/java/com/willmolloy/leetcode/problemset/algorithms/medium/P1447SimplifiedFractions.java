package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/simplified-fractions>https://leetcode.com/problems/simplified-fractions/</a>
 *
 * <p>Runtime: O(n<sup>2</sup>) * O(gcd)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key idea: Fraction is simplified if GCD of numerator and denominator is 1.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1447SimplifiedFractions {

  public List<String> simplifiedFractions(int n) {
    List<String> result = new ArrayList<>();

    for (int denominator = 1; denominator <= n; denominator++) {
      for (int numerator = 1; numerator < denominator; numerator++) {
        if (isSimple(numerator, denominator)) {
          result.add(String.format("%s/%s", numerator, denominator));
        }
      }
    }
    return result;
  }

  private boolean isSimple(int numerator, int denominator) {
    return BigInteger.valueOf(numerator)
        .gcd(BigInteger.valueOf(denominator))
        .equals(BigInteger.ONE);
  }
}
