package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.stream.IntStream;

/**
 * <a href=https://leetcode.com/problems/count-primes>https://leetcode.com/problems/count-primes</a>
 *
 * <p>Runtime: O(n log log n)
 *
 * <p>Space: O(n)
 *
 * <p>Key idea: can stop at {@code sqrt(n)} because beyond that we can not eliminate potential
 * primes as we've already tested the other side of the multiple.
 *
 * @see <a
 *     href=https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes>https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes</a>
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P204CountPrimes {

  public int countPrimes(int n) {
    // sieve[i] = FALSE means i is prime, initially mark all as prime
    boolean[] sieve = new boolean[n];

    // go through each prime so far (in order)
    // eliminating multiples of that prime as a potential prime
    for (int p = 2; p * p < n; p++) { // p * p < n <=> p < sqrt(n)
      if (sieve[p]) {
        continue;
      }
      // starts from p*p rather than 2p (or 3p etc.) because those numbers were already marked off
      // by prior primes
      for (int i = p * p; i < n; i += p) {
        sieve[i] = true;
      }
    }
    return (int) IntStream.range(2, n).filter(i -> !sieve[i]).count();
  }
}
