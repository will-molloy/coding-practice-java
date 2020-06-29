package com.wilmol.projecteuler.problems.difficulty5;

import com.google.common.base.Preconditions;
import com.wilmol.projecteuler.common.Maths;
import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * <a href=https://projecteuler.net/problem=53>https://projecteuler.net/problem=53</a>
 *
 * <p>Runtime: O(n ^ 2)
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
final class P53CombinatoricSelections {

  private P53CombinatoricSelections() {}

  static int countGreaterThanOneMillion(int limit) {
    Preconditions.checkArgument(limit > 0);

    return (int)
        IntStream.rangeClosed(1, limit)
            .boxed()
            .flatMap(n -> IntStream.rangeClosed(1, n).mapToObj(r -> Maths.choose(n, r)))
            .filter(result -> result.compareTo(BigInteger.valueOf(1_000_000)) > 0)
            .count();
  }
}
