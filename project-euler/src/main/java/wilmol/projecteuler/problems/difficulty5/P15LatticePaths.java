package wilmol.projecteuler.problems.difficulty5;

import static wilmol.projecteuler.common.Maths.factorial;

import java.math.BigInteger;

/**
 * Created by Will on 17/03/2019.
 *
 * <p><a href=https://projecteuler.net/problem=15>https://projecteuler.net/problem=15</a>
 *
 * <p>Runtime: O((n + m) * n * m)
 */
class P15LatticePaths {

  // it's just binomial coefficient (i.e. permutations of binary number)
  // e.g. 0 = down, 1 = right
  // 2x2 -> (1100) (1010) (1001) (0110) (0101) (0011)
  public BigInteger apply(int rows, int cols) {
    return factorial(rows + cols).divide(factorial(rows).multiply(factorial(cols)));
  }
}
