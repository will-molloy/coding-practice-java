package wilmol.projecteuler.common;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.math.BigIntegerMath;
import com.google.common.math.IntMath;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by Will on 17/03/2019.
 *
 * <p>Common math functions
 *
 * @see java.lang.Math
 * @see com.google.common.math
 */
public final class Maths {

  private Maths() {}

  /** Computes the product of the collection of numbers (as a long, precision is lost). */
  public static <T extends Number> long product(Collection<T> numbers) {
    checkNotNull(numbers);

    // Empty set product is 1, the identity of multiplication
    return numbers.stream().mapToLong(Number::longValue).reduce(1L, (a, b) -> a * b);
  }

  /** Computes the factorial of n. */
  public static BigInteger factorial(long n) {
    // 0! is 1, the identity of multiplication
    return LongStream.rangeClosed(1, n)
        .mapToObj(BigInteger::valueOf)
        .reduce(BigInteger.valueOf(1L), BigInteger::multiply);
  }

  /**
   * Determines if n is prime.
   *
   * @deprecated Use {@link com.google.common.math.LongMath#isPrime(long)}
   */
  @Deprecated
  public static boolean isPrime(long n) {
    return n > 1
        && (n == 2 || LongStream.rangeClosed(2, (long) Math.sqrt(n)).noneMatch(k -> n % k == 0));
  }

  public static long sumFirstNNaturalNumbers(long n) {
    return (n + 1) * n / 2;
  }

  public static long numDivisors(long n) {
    // test up to square root and double up
    return LongStream.rangeClosed(1L, (long) Math.sqrt(n)).filter(i -> n % i == 0).count() * 2;
  }

  /** Sum of divisors (excluding n itself). */
  public static int sumOfProperDivisors(int n) {
    return IntStream.range(1, n).filter(i -> n % i == 0).sum();
  }

  /** Return the number of digits in n (excluding leading zeros). */
  public static int digitLength(BigInteger n) {
    return BigIntegerMath.log10(n, RoundingMode.FLOOR) + 1;
  }

  /** Return the number of digits in n (excluding leading zeros). */
  public static int digitLength(long n) {
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      n *= -1;
    }
    return (int) Math.floor(Math.log10(n)) + 1;
  }

  /** Return all primes below the given limit. */
  public static List<Long> allPrimesBelow(int below) {
    if (below < 2) {
      return List.of();
    }

    // Sieve of Eratosthenes https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
    // only need to test against current list of primes when generating sequence of primes from
    // smallest prime.
    // Note, since using Java 8 Collector interface, the result is eager (a collection) not lazy
    // (not a stream)
    // no way around this since Stream.collect() is a terminal operation on the pipeline.
    return LongStream.range(2, below)
        .sequential()
        .collect(
            ArrayList::new,
            (currentPrimes, candidatePrime) -> {
              long candidateRoot = (long) Math.sqrt(candidatePrime);
              if (currentPrimes.stream()
                  .takeWhile(p -> p <= candidateRoot)
                  .noneMatch(p -> candidatePrime % p == 0)) {
                currentPrimes.add(candidatePrime);
              }
            },
            List::addAll);
  }

  /** Return true if the given value is an integer. I.e. has no fractional component. */
  public static boolean isInteger(double d) {
    return Double.compare((int) d, d) == 0;
  }

  /** Return the next prime above the given starting value. */
  public static int nextPrime(int greaterThan) {
    return IntStream.iterate(greaterThan + 1, i -> i + 1)
        .filter(IntMath::isPrime)
        .findFirst()
        .getAsInt();
  }

  /** Combinatorics choose function. */
  public static BigInteger choose(int n, int r) {
    return BigIntegerMath.factorial(n)
        .divide(BigIntegerMath.factorial(r).multiply(BigIntegerMath.factorial(n - r)));
  }
}
