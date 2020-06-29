package com.wilmol.projecteuler.problems.difficulty5;

import com.google.common.math.IntMath;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href=https://projecteuler.net/problem=35>https://projecteuler.net/problem=35</a>
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
final class P35CircularPrimes {

  private P35CircularPrimes() {}

  static long numCircularPrimesBelow(int limit) {
    return IntStream.range(2, limit).parallel().filter(P35CircularPrimes::isCircularPrime).count();
  }

  private static boolean isCircularPrime(int n) {
    // test n itself is prime
    if (!IntMath.isPrime(n)) {
      return false;
    }

    // test the rotations of n are prime
    // num rotations is num digits in n
    int[] digits = String.valueOf(n).chars().map(Character::getNumericValue).toArray();
    return IntStream.range(1, digits.length)
        .allMatch(
            rotateBy -> {
              // rotate left
              int[] rotatedDigits = new int[digits.length];
              for (int j = 0; j < digits.length; j++) {
                rotatedDigits[j] = digits[(j + rotateBy) % digits.length];
              }
              // 'glue' together and test primality
              int rotation =
                  Integer.parseInt(
                      Arrays.stream(rotatedDigits)
                          .mapToObj(String::valueOf)
                          .collect(Collectors.joining()));
              return IntMath.isPrime(rotation);
            });
  }
}
