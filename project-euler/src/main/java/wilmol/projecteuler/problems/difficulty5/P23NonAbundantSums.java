package wilmol.projecteuler.problems.difficulty5;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by Will on 18/03/2019.
 *
 * <p><a href=https://projecteuler.net/problem=23>https://projecteuler.net/problem=23</a>
 *
 * <p>Runtime: O(n ^ 2) ...
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
