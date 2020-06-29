package com.wilmol.projecteuler.problems.difficulty5;

import com.google.common.math.LongMath;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import org.apache.commons.lang3.tuple.Pair;

/**
 * <a href=https://projecteuler.net/problem=26>https://projecteuler.net/problem=26</a>
 *
 * <p>Runtime: O(p * k) (p - number of primes in n) (k - avg recurring cycle length)
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P26ReciprocalCycles {

  public int apply(int limit) {
    return IntStream.range(3, limit)
        // only primes cause reciprocal cycles, except those that are the factors of the base
        // (base10, so filter 2 and 5)
        .filter(d -> d != 2 && d != 5 && LongMath.isPrime(d))
        .boxed()
        // compute for 1/d
        .max(Comparator.comparingInt(d -> reciprocalCycleLength(1, d, new ArrayList<>())))
        .orElse(0);
  }

  // pairs of fractions
  // keep computing until a duplicate is found (i.e. the sequence has started to repeat)
  private int reciprocalCycleLength(int numerator, int denominator, List<Pair> fractions) {
    if (numerator == 0) {
      // base case, numerator of zero means the sequence ended and does not recur (e.g. 0.500 ...)
      return 0;
    }

    Pair nextFraction = Pair.of(numerator, denominator);
    if (fractions.contains(nextFraction)) {
      // base case, sequence started to repeat, compute the sequence length e.g. 0.(142857)
      // NOT the number of fractions, could've started repeating further down e.g. 0.1(6)
      return fractions.size() - fractions.indexOf(nextFraction);
    } else {
      // recursive case, compute and check the next fraction in the sequence
      fractions.add(nextFraction);
      int nextNumerator = (numerator * 10) % denominator;
      return reciprocalCycleLength(nextNumerator, denominator, fractions);
    }
  }
}
