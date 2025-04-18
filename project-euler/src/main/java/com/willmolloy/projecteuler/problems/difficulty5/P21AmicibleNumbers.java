package com.willmolloy.projecteuler.problems.difficulty5;

import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;

import com.willmolloy.projecteuler.common.Maths;

/**
 * <a href=https://projecteuler.net/problem=21>https://projecteuler.net/problem=21</a>
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P21AmicibleNumbers {

  public int apply(int under) {
    // must map from zero else the indices don't line up
    int[] d = rangeClosed(0, under).map(Maths::sumOfProperDivisors).toArray();

    return range(1, under)
        .filter(
            a -> {
              int b = d[a];
              return b < d.length && a != b && d[a] == b && d[b] == a;
            })
        .sum();
  }
}
