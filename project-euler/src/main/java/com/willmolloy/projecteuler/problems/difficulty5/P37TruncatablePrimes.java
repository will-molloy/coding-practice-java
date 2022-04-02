package com.willmolloy.projecteuler.problems.difficulty5;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.math.LongMath;
import com.willmolloy.projecteuler.common.Maths;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;

/**
 * <a href=https://projecteuler.net/problem=37>https://projecteuler.net/problem=37</a>
 *
 * <p>Runtime: none
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P37TruncatablePrimes {

  private P37TruncatablePrimes() {}

  // only appending these values (odd numbers or 2) will result in prime numbers
  private static final List<Long> DIGITS = List.of(2L, 1L, 3L, 5L, 7L, 9L);

  private static final Set<Long> STARTING_PRIMES =
      DIGITS.stream().filter(LongMath::isPrime).collect(ImmutableSet.toImmutableSet());

  static long truncatablePrimesSum() {
    // only interested in those that can be truncated left AND right
    Set<Long> truncatablePrimes =
        Sets.intersection(
            truncatablePrimes(P37TruncatablePrimes::appendLeft),
            truncatablePrimes(P37TruncatablePrimes::appendRight));
    assert truncatablePrimes.size() == 11;
    return truncatablePrimes.stream().reduce(0L, Long::sum);
  }

  private static Long appendLeft(Long oldPrime, Long digit) {
    // append digit to left of old prime
    return LongMath.pow(10, Maths.digitLength(oldPrime)) * digit + oldPrime;
  }

  private static Long appendRight(Long oldPrime, Long digit) {
    // append digit to right of old prime
    return oldPrime * 10 + digit;
  }

  private static Set<Long> truncatablePrimes(BiFunction<Long, Long, Long> appender) {
    return truncatablePrimes(appender, STARTING_PRIMES, Set.of());
  }

  // Each recursive call represents the number of digits in each prime
  // since it starts at one and appends digits before gathering the result, will avoid [2, 3, 5, 7]
  // in the result
  private static Set<Long> truncatablePrimes(
      BiFunction<Long, Long, Long> digitAppender, Set<Long> primes, Set<Long> result) {
    // append digits to each of the primes and check primality
    Set<Long> newPrimes =
        primes.stream()
            .flatMap(oldPrime -> DIGITS.stream().map(digit -> digitAppender.apply(oldPrime, digit)))
            .filter(LongMath::isPrime)
            .collect(ImmutableSet.toImmutableSet());

    if (newPrimes.isEmpty()) {
      // no new primes are built (impossible for there to be any more truncatable primes given an
      // intermediate value failed)
      return result;
    }
    return truncatablePrimes(digitAppender, newPrimes, Sets.union(newPrimes, result));
  }
}
