package com.wilmol.projecteuler.problems.difficulty5;

import com.google.common.base.Preconditions;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by will on 2019-04-19 at 9:01 PM.
 *
 * <p><a href=https://projecteuler.net/problem=40>https://projecteuler.net/problem=40</a>
 *
 * <p>Runtime: O(n)
 */
final class P40ChampernownesConstants {

  private P40ChampernownesConstants() {}

  static int apply(Set<Integer> digits) {
    Preconditions.checkArgument(!digits.isEmpty());
    int max = digits.stream().mapToInt(Integer::intValue).max().getAsInt();
    Preconditions.checkArgument(max >= 1);

    int[] decimalValues =
        IntStream.iterate(0, i -> i + 1)
            // flat map to stream individual digits
            .flatMap(i -> String.valueOf(i).chars().map(Character::getNumericValue))
            .limit(max + 1)
            .toArray();

    return digits.stream().map(i -> decimalValues[i]).reduce(1, (a, b) -> a * b);
  }
}
