package com.willmolloy.projecteuler.problems.difficulty5;

import com.google.common.base.Preconditions;
import com.willmolloy.projecteuler.common.Maths;
import java.math.BigInteger;

/**
 * <a href=https://projecteuler.net/problem=25>https://projecteuler.net/problem=25</a>
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P25NDigitFibonacciNumber {

  public int fibIndex(final int digits) {
    Preconditions.checkArgument(digits > 0);

    BigInteger a = BigInteger.valueOf(0);
    BigInteger b = BigInteger.valueOf(1);
    int index = 1;

    while (Maths.digitLength(b) != digits) {
      BigInteger temp = b;
      b = b.add(a);
      a = temp;

      index++;
    }
    return index;
  }
}
