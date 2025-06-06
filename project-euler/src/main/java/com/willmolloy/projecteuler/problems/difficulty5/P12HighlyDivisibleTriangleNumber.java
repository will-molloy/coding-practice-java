package com.willmolloy.projecteuler.problems.difficulty5;

import com.willmolloy.projecteuler.common.Maths;
import java.util.OptionalLong;
import java.util.stream.LongStream;

/**
 * <a href=https://projecteuler.net/problem=12>https://projecteuler.net/problem=12</a>
 *
 * <p>Runtime: O(n * sqrt(n))
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P12HighlyDivisibleTriangleNumber {
  public OptionalLong apply(long divisorsAbove) {
    return LongStream.iterate(1, i -> i + 1)
        .map(Maths::sumFirstNNaturalNumbers)
        .filter(i -> Maths.numDivisors(i) > divisorsAbove)
        .findFirst();
  }
}
