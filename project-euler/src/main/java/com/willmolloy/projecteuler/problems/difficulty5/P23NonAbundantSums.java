package com.willmolloy.projecteuler.problems.difficulty5;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * <a href=https://projecteuler.net/problem=23>https://projecteuler.net/problem=23</a>
 *
 * <p>Runtime: O(n ^ 2) ...
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P23NonAbundantSums {

  private static boolean isAbundant(int n) {
    return IntStream.range(1, n).filter(i -> n % i == 0).sum() > n;
  }

  public int apply(int limit) {
    Set<Integer> range =
        IntStream.rangeClosed(1, limit).boxed().collect(ImmutableSet.toImmutableSet());
    Set<Integer> abundantNumbers =
        range.stream()
            .filter(P23NonAbundantSums::isAbundant)
            .collect(ImmutableSet.toImmutableSet());
    Set<Integer> sumOfTwoAbundant =
        abundantNumbers.stream()
            .flatMap(
                a ->
                    abundantNumbers.stream()
                        .map(b -> a + b)
                        .filter(
                            i -> i <= limit)) // filter before set difference provides some speed up
            .collect(ImmutableSet.toImmutableSet());

    return Sets.difference(range, sumOfTwoAbundant).stream().mapToInt(Integer::intValue).sum();
  }
}
