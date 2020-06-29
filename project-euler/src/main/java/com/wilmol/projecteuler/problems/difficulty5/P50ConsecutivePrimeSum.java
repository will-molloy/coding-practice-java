package com.wilmol.projecteuler.problems.difficulty5;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.math.IntMath;
import java.util.List;
import java.util.stream.IntStream;

/**
 * <a href=https://projecteuler.net/problem=50>https://projecteuler.net/problem=50</a>
 *
 * <p>Runtime: O(n ^ 2)
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
final class P50ConsecutivePrimeSum {

  private P50ConsecutivePrimeSum() {}

  static int longestConsecutivePrimeSumPrimeResultBelow(int limit) {
    Preconditions.checkArgument(limit > 2);

    // compute primes ahead of time (need them cached AND need to know how many there are)
    List<Integer> primes =
        IntStream.rangeClosed(2, limit)
            .filter(IntMath::isPrime)
            .boxed()
            .collect(ImmutableList.toImmutableList());

    int bestPrime = 2;
    int bestLength = 1;

    // iterate each prime
    for (int primesStartIndex = 0; primesStartIndex < primes.size(); primesStartIndex++) {
      // compute consecutive prime sum starting from each prime
      int currentPrimeSum = 0;
      int currentLength = 0;
      for (int primesIndex = primesStartIndex; primesIndex < primes.size(); primesIndex++) {
        // stop when prime sum exceeds limit
        if (currentPrimeSum > limit) {
          break;
        }
        // check for 'best' each iteration
        if (currentLength > bestLength && IntMath.isPrime(currentPrimeSum)) {
          bestPrime = currentPrimeSum;
          bestLength = currentLength;
        }
        currentPrimeSum += primes.get(primesIndex);
        currentLength += 1;
      }
    }
    return bestPrime;
  }
}
