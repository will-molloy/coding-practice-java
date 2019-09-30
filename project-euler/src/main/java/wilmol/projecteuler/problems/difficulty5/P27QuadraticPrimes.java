package wilmol.projecteuler.problems.difficulty5;

import static java.util.Comparator.comparing;

import java.util.function.Supplier;
import java.util.stream.IntStream;
import org.apache.commons.lang3.tuple.Pair;
import wilmol.projecteuler.common.Maths;

/**
 * Created by Will on 23/03/2019.
 *
 * <p><a href=https://projecteuler.net/problem=27>https://projecteuler.net/problem=27</a>
 *
 * <p>Runtime: O(a * b)
 */
class P27QuadraticPrimes {

  // consecutive primes, i.e. x = 0 until n, where f(n) is not prime.
  public int apply(int aLimit, int bLimit) {
    // b must be prime (for x = 0, f(0) = b)
    Supplier<IntStream> bRange = () -> IntStream.rangeClosed(0, bLimit).filter(Maths::isPrime);

    // a must be odd (for x = 1, f(1) = 1 + a + b (where b is prime and therefore also odd))
    IntStream aRange = IntStream.rangeClosed(-aLimit, aLimit).filter(n -> Math.abs(n) % 2 == 1);

    Pair<Integer, Integer> abCoefficients =
        aRange
            .boxed()
            .flatMap(a -> bRange.get().mapToObj(b -> Pair.of(a, b)))
            .max(comparing(this::primeSeqLength))
            .orElse(Pair.of(0, 0));
    return abCoefficients.getLeft() * abCoefficients.getRight();
  }

  // number of consecutive primes produced by the formula
  private long primeSeqLength(Pair<Integer, Integer> ab) {
    return IntStream.iterate(0, n -> n + 1)
        .map(n -> quadratic(n, ab))
        .takeWhile(Maths::isPrime)
        .count();
  }

  private int quadratic(int x, Pair<Integer, Integer> ab) {
    return x * x + ab.getLeft() * x + ab.getRight();
  }
}
