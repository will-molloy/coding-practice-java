package wilmol.projecteuler.problems.difficulty5;

import java.util.OptionalLong;
import java.util.stream.LongStream;
import wilmol.projecteuler.common.Maths;

/**
 * Created by Will on 17/03/2019.
 *
 * <p><a href=https://projecteuler.net/problem=12>https://projecteuler.net/problem=12</a>
 *
 * <p>Runtime: O(n * sqrt(n))
 */
class P12HighlyDivisibleTriangleNumber {
  public OptionalLong apply(long divisorsAbove) {
    return LongStream.iterate(1, i -> i + 1)
        .map(Maths::sumFirstNNaturalNumbers)
        .filter(i -> Maths.numDivisors(i) > divisorsAbove)
        .findFirst();
  }
}
