package com.willmolloy.projecteuler.problems.difficulty5;

import static com.willmolloy.projecteuler.common.Maths.factorial;

import java.math.BigInteger;

/**
 * <a href=https://projecteuler.net/problem=15>https://projecteuler.net/problem=15</a>
 *
 * <p>Runtime: O((n + m) * n * m)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P15LatticePaths {

  // it's just binomial coefficient (i.e. permutations of binary number)
  // e.g. 0 = down, 1 = right
  // 2x2 -> (1100) (1010) (1001) (0110) (0101) (0011)
  public BigInteger apply(int rows, int cols) {
    return factorial(rows + cols).divide(factorial(rows).multiply(factorial(cols)));
  }
}
