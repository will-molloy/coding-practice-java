package com.wilmol.projecteuler.problems.difficulty5;

import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;

/**
 * Created by Will on 16/03/2019.
 *
 * <p><a href=https://projecteuler.net/problem=7>https://projecteuler.net/problem=7</a>
 *
 * <p>Runtime: O(n)
 */
class P7NthPrime {

  public int apply(int n) {
    Preconditions.checkArgument(n > 0);

    if (n == 1) {
      return 2;
    }

    int count = 2;
    int prime = 3;
    while (count < n) {
      prime += 2;
      if (LongMath.isPrime(prime)) {
        count++;
      }
    }
    return prime;
  }
}
