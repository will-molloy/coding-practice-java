package com.wilmol.projecteuler.problems.difficulty5;

import com.wilmol.projecteuler.common.Maths;

/**
 * Created by Will on 17/03/2019.
 *
 * <p><a href=https://projecteuler.net/problem=20>https://projecteuler.net/problem=20</a>
 *
 * <p>Runtime: O(n) (product and sum..)
 */
class P20FactorialDigitSum {

  public int apply(int n) {
    return Maths.factorial(n).toString().chars().map(Character::getNumericValue).sum();
  }
}
