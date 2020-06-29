package com.wilmol.projecteuler.problems.difficulty30;

import com.wilmol.projecteuler.problems.difficulty5.P31CoinSums;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <a href=https://projecteuler.net/problem=78>https://projecteuler.net/problem=78</a>
 *
 * <p>Runtime: O(n * sqrt(n)) - inner loop generates k proportional to sqrt(n) see: <a
 * href=https://en.wikipedia.org/wiki/Partition_function_(number_theory)#Recurrence_relations>https://en.wikipedia.org/wiki/Partition_function_(number_theory)#Recurrence_relations</a>
 *
 * @see P31CoinSums
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
public final class P78CoinPartitions {

  private P78CoinPartitions() {}

  private static final Logger LOG = LogManager.getLogger();

  /**
   * p(n) = <a
   * href=https://en.wikipedia.org/wiki/Partition_function_(number_theory)#Recurrence_relations>partition
   * function</a>
   *
   * <p>Note: Similar to problem 31 (coin sum problem, just with coins 1..n).
   *
   * <p>There are many large results. Therefore, use a 1D array (otherwise OutOfMemoryError). Also
   * store results mod 1,000,000 otherwise overflows. Could use BigInteger, but don't care about
   * actual p(n) value, and its slower.
   *
   * <p>Because a 1D array is used while we are constantly generating new p(n) (i.e. maximum n is
   * unknown at the start), cannot do standard 2D dynamic programming approach as done in problem
   * 31.
   *
   * <p>This is because, when doing bottom up dynamic programming we rely on the partial results.
   * However, because we are constantly generating new 'n' and using 1D array, we throw away the
   * partial results.
   *
   * <p>Therefore cannot do that approach (technically could if we guessed an upper bound for n).
   *
   * <p>Instead use the partition function recurrence relation, which relies on previous (but non
   * partial) results.
   *
   * @return the smallest n with p(n) divisible by 1,000,000
   */
  static int findFirstPartitionDivisibleByOneMillion() {
    // need to store all previous results
    List<Integer> pnBuffer = new ArrayList<>();

    // base cases
    // n = 0
    pnBuffer.add(1);
    // n = 1
    pnBuffer.add(1);

    // n = 2..inf
    return IntStream.iterate(2, n -> n + 1)
        .filter(
            n -> {
              // sum for k != 0 (i.e. k = 1, -1, 2, -2, 3, -3, 4, -4, ..., inf, -inf)
              // sum: (-1)^(k + 1) * p(n - k(3k -1) / 2)
              int pn =
                  IntStream.iterate(1, k -> k + 1)
                      .flatMap(k -> IntStream.of(k, -k))
                      .map(
                          k -> {
                            // (-1)^(k + 1) => even k = negative, odd k = positive
                            int multiplier = k % 2 == 0 ? -1 : 1;
                            int offset = k * (3 * k - 1) / 2;
                            int index = n - offset;
                            if (index < 0) {
                              // base case: p(n) for n < 0 is zero, no need to continue the infinite
                              // sum
                              return 0;
                            }
                            return multiplier * pnBuffer.get(index);
                          })
                      .takeWhile(partialSum -> partialSum != 0)
                      .sum();

              // store pn mod 1,000,000 to avoid integer overflows
              // works since we only care about the last 6 digits and are performing addition
              pn %= 1_000_000;

              if (pn == 0) {
                LOG.info("Found first p(n) divisible by 1,000,000 for n = [{}]", n);
                return true;
              }
              pnBuffer.add(pn);

              if (n % 10_000 == 0) {
                LOG.debug("n [{}]", n);
              }
              return false;
            })
        .findFirst()
        .getAsInt();
  }
}
