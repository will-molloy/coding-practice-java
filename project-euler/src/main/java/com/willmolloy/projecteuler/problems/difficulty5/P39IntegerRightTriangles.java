package com.willmolloy.projecteuler.problems.difficulty5;

import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * <a href=https://projecteuler.net/problem=39>https://projecteuler.net/problem=39</a>
 *
 * <p>Runtime: O(n ^ 3)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P39IntegerRightTriangles {

  private P39IntegerRightTriangles() {}

  static int perimeterWithMaxNumberOfSolutions(int limit) {
    return IntStream.rangeClosed(3, limit)
        .parallel()
        .boxed()
        // max by
        .max(Comparator.comparingInt(P39IntegerRightTriangles::numberOfSolutions))
        .orElseThrow();
  }

  static int numberOfSolutions(int perimeter) {
    return (int)
        IntStream.rangeClosed(1, perimeter - 2)
            .mapToLong(
                a ->
                    IntStream.range(a + 1, perimeter - a)
                        .filter(
                            b -> {
                              int c = perimeter - a - b;
                              return a * a + b * b == c * c;
                            })
                        .count())
            .sum();
  }
}
