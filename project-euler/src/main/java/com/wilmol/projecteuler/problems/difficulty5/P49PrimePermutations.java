package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.math.IntMath.isPrime;
import static com.google.common.primitives.Ints.join;

import java.util.stream.IntStream;

/**
 * Created by will on 2019-04-21 at 2:31 PM.
 *
 * <p><a href=https://projecteuler.net/problem=49>https://projecteuler.net/problem=49</a>
 *
 * <p>Runtime: O(n)
 */
final class P49PrimePermutations {

  private P49PrimePermutations() {}

  private static final int INCREASING_VALUE = 3330;

  static String nInSequenceWithPrimePermutationProperty(int n) {
    // search 4 digit numbers
    return IntStream.rangeClosed(1000, 9999 - INCREASING_VALUE * 2)
        .filter(
            a -> {
              // verify all 3 values are prime
              if (!isPrime(a)) {
                return false;
              }
              int b = a + INCREASING_VALUE;
              int c = a + INCREASING_VALUE * 2;
              if (!isPrime(b) || !isPrime(c)) {
                return false;
              }

              // verify all 3 values are permutations of each other
              String sortedDigitsA = sortDigits(a);
              return sortedDigitsA.equals(sortDigits(b)) && sortedDigitsA.equals(sortDigits(c));
            })
        // take n'th element in stream
        .limit(n)
        .skip(n - 1)
        // glue together the 3 values
        .mapToObj(a -> join("", a, a + INCREASING_VALUE, a + INCREASING_VALUE * 2))
        .iterator()
        .next();
  }

  private static String sortDigits(int n) {
    return join("", String.valueOf(n).chars().sorted().toArray());
  }
}
