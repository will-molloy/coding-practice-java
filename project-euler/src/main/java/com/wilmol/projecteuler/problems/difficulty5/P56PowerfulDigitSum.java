package com.wilmol.projecteuler.problems.difficulty5;

import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * Created by wilmol on 2019-05-02.
 *
 * <p><a href=https://projecteuler.net/problem=56>https://projecteuler.net/problem=56</a>
 *
 * <p>Runtime: O(n ^ 2)
 */
final class P56PowerfulDigitSum {

  private P56PowerfulDigitSum() {}

  static int solve(int range) {
    return IntStream.range(1, range)
        .flatMap(a -> IntStream.range(1, range).map(b -> digitSum(a, b)))
        .max()
        .getAsInt();
  }

  private static int digitSum(int a, int b) {
    BigInteger value = BigInteger.valueOf(a).pow(b);
    return value.toString().chars().map(Character::getNumericValue).sum();
  }
}
