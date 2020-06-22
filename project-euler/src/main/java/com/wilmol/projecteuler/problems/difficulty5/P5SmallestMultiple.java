package com.wilmol.projecteuler.problems.difficulty5;

import com.google.common.base.Preconditions;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * Created by Will on 16/03/2019.
 *
 * <p><a href=https://projecteuler.net/problem=5>https://projecteuler.net/problem=5</a>
 *
 * <p>Runtime: O(n ^ 2)
 */
class P5SmallestMultiple {

  public OptionalInt apply(int from, int to) {
    Preconditions.checkArgument(to > from);

    return IntStream.iterate(to, i -> i + 1)
        .filter(i -> IntStream.rangeClosed(from, to).allMatch(j -> i % j == 0))
        .findFirst();
  }
}
