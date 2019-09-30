package wilmol.projecteuler.problems.difficulty5;

import java.math.BigInteger;

/**
 * Created by Will on 17/03/2019.
 *
 * <p><a href=https://projecteuler.net/problem=16>https://projecteuler.net/problem=16</a>
 *
 * <p>Runtime: O(b ^ e)
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
