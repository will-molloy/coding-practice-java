package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * <a
 * href=https://leetcode.com/problems/prime-arrangements>https://leetcode.com/problems/prime-arrangements/</a>
 *
 * <p>Difficulty: Easy.
 *
 * <p>Runtime: O(n log(log(n)))
 *
 * <p>Space: O(n)
 *
 * <p>Key: When computing {@code result} use {@code long} to avoid overflows.
 *
 * @see P204CountPrimes
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1175PrimeArrangements {

  private static final int MOD = (int) (1e9 + 7);

  public int numPrimeArrangements(int n) {
    // count num primes and non primes

    // prime sieve
    boolean[] sieve = new boolean[n + 1];
    Arrays.fill(sieve, 2, n + 1, true);

    for (int p = 2; p * p <= n; p++) {
      if (sieve[p]) {
        for (int i = p * p; i <= n; i += p) {
          sieve[i] = false;
        }
      }
    }

    int primeCount = (int) IntStream.rangeClosed(2, n).filter(i -> sieve[i]).count();
    int nonPrimeCount = n - primeCount;

    // num permutation is factorial
    // since the indices for non primes and primes are disjoint it's just the cartesian product
    // i.e. primeCount! * nonPrimeCount!

    long result = 1;
    for (int i = 1; i <= primeCount; i++) {
      result *= i;
      result %= MOD;
    }
    // (factorial and cartesian product are computed using multiplication so can just continue)
    for (int i = 1; i <= nonPrimeCount; i++) {
      result *= i;
      result %= MOD;
    }
    return (int) result;
  }
}
