package com.willmolloy.projecteuler.problems.difficulty5;

import com.google.common.base.Preconditions;
import java.math.BigInteger;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * <a href=https://projecteuler.net/problem=29>https://projecteuler.net/problem=29</a>
 *
 * <p>Runtime: O(n ^ 2)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P29DistinctPowers {

  public int apply(int lower, int higher) {
    Preconditions.checkArgument(higher > lower);

    Supplier<IntStream> range = () -> IntStream.rangeClosed(lower, higher);

    // Only way is to brute force the pairs ...
    return (int)
        range
            .get()
            .boxed()
            .flatMap(a -> range.get().mapToObj(b -> BigInteger.valueOf(a).pow(b)))
            .distinct()
            .count();
  }
}
