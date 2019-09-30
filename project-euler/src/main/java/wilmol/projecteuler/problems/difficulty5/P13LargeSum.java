package wilmol.projecteuler.problems.difficulty5;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Will on 17/03/2019.
 *
 * <p><a href=https://projecteuler.net/problem=13>https://projecteuler.net/problem=13</a>
 *
 * <p>Runtime: O(n * m) (addition is linear?)
 */
class P13LargeSum {

  public String apply(List<BigInteger> numbers, int numDigits) {
    return numbers.stream()
        .reduce(BigInteger.valueOf(0), BigInteger::add)
        .toString()
        .substring(0, numDigits);
  }
}
