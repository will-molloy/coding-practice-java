package com.willmolloy.projecteuler.problems.difficulty5;

import com.google.common.base.Preconditions;
import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * <a href=https://projecteuler.net/problem=48>https://projecteuler.net/problem=48</a>
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P48SelfPowers {

  private P48SelfPowers() {}

  static String lastDigitsOfSelfPowersSumSeries(int limit, int lastDigits) {
    Preconditions.checkArgument(limit >= 1);

    String sum =
        IntStream.rangeClosed(1, limit)
            .mapToObj(n -> BigInteger.valueOf(n).pow(n))
            .reduce(BigInteger::add)
            .orElseThrow()
            .toString();

    if (lastDigits >= sum.length() || lastDigits == -1) {
      return sum;
    }
    return sum.substring(sum.length() - lastDigits);
  }
}
