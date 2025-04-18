package com.willmolloy.projecteuler.problems.difficulty5;

import com.willmolloy.projecteuler.common.Maths;

/**
 * <a href=https://projecteuler.net/problem=20>https://projecteuler.net/problem=20</a>
 *
 * <p>Runtime: O(n) (product and sum..)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P20FactorialDigitSum {

  public int apply(int n) {
    return Maths.factorial(n).toString().chars().map(Character::getNumericValue).sum();
  }
}
