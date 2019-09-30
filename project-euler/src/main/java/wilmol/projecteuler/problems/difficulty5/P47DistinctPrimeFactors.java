package wilmol.projecteuler.problems.difficulty5;

import static wilmol.projecteuler.common.Maths.nextPrime;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by will on 2019-04-20 at 5:43 PM.
 *
 * <p><a href=https://projecteuler.net/problem=47>https://projecteuler.net/problem=47</a>
 *
 * <p>Runtime: O(n)
 */
final class P47DistinctPrimeFactors {

  private P47DistinctPrimeFactors() {}

  static int firstOfSetWithSizeNAndNDistinctConsecutivePrimeFactors(int n) {
    Preconditions.checkArgument(n >= 2);

    int[] count = {0};
    return IntStream.iterate(1, i -> i + 1)
        .filter(
            i -> {
              // no point checking primes (will only have one prime factor, themselves)
              if (!IntMath.isPrime(i) && distinctPrimeFactors(i).size() == n) {
                count[0] += 1;
              } else {
                count[0] = 0;
              }
              return count[0] == n;
            })
        .findFirst().stream()
        // take first element in the set of size 'n' (simply subtract, since they are consecutive)
        .map(lastOfSet -> lastOfSet - n + 1)
        .findFirst()
        .getAsInt();
  }

  private static final List<Integer> PRIMES_CACHE = new ArrayList<>(List.of(2));

  private static Set<Integer> distinctPrimeFactors(int n) {
    Set<Integer> primeFactors = new HashSet<>();
    int primeIndex = 0;
    int prime = 2;
    while (n != 1) {
      if (n % prime == 0) {
        primeFactors.add(prime);
        n /= prime;
      } else {
        primeIndex += 1;
        if (primeIndex == PRIMES_CACHE.size()) {
          PRIMES_CACHE.add(nextPrime(prime));
        }
        prime = PRIMES_CACHE.get(primeIndex);
      }
    }
    return primeFactors;
  }
}
