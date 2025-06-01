package com.willmolloy.projecteuler.problems.difficulty5;

import static com.willmolloy.projecteuler.common.Maths.nextPrime;

import com.google.common.math.IntMath;
import com.willmolloy.projecteuler.common.Maths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * <a href=https://projecteuler.net/problem=46>https://projecteuler.net/problem=46</a>
 *
 * <p>Runtime: none
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P46GoldbachsOtherConjecture {

  private P46GoldbachsOtherConjecture() {}

  private static final List<Integer> PRIMES_CACHE = new ArrayList<>(List.of(2));

  static int firstOddCompositeNotSumOfPrimeAndTwiceASquare() {
    // iterate odd composites
    return IntStream.iterate(9, i -> i + 2)
        .filter(n -> !IntMath.isPrime(n) && notSumOfPrimeAndTwiceASquare(n))
        .findFirst()
        .getAsInt();
  }

  private static boolean notSumOfPrimeAndTwiceASquare(int n) {
    // try subtracting all primes less than n
    // then divide two and take sqrt
    // if the sqrt is an integer, the square is valid
    // therefore n is the sum of a prime and twice a square

    return IntStream.iterate(0, i -> i + 1)
        // keep buffer of primes so they are only computed once and lazily
        .peek(
            primesIndex -> {
              if (primesIndex == PRIMES_CACHE.size()) {
                int lastPrime = PRIMES_CACHE.getLast();
                PRIMES_CACHE.add(nextPrime(lastPrime));
              }
            })
        .map(PRIMES_CACHE::get)
        .takeWhile(lastPrime -> lastPrime < n)
        .noneMatch(
            lastPrime -> {
              int withoutPrime = n - lastPrime;
              int divideTwo = withoutPrime / 2;
              double sqrt = Math.sqrt(divideTwo);
              return Maths.isInteger(sqrt);
            });
  }
}
