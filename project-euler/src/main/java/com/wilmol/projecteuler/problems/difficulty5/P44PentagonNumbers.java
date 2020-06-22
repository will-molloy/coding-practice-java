package com.wilmol.projecteuler.problems.difficulty5;

import com.wilmol.projecteuler.common.Maths;
import com.wilmol.projecteuler.common.Tuples;
import java.util.stream.IntStream;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Created by will on 2019-04-20 at 12:11 PM.
 *
 * <p><a href=https://projecteuler.net/problem=44>https://projecteuler.net/problem=44</a>
 *
 * <p>Runtime: none
 */
final class P44PentagonNumbers {

  private P44PentagonNumbers() {}

  static int minimisedPentagonPairDifferenceWithPentagonSumAndPentagonDifference() {
    // since the pentagon values grow with n (pn proportional to square of n), start by pairing up
    // smaller values
    // then the first valid pair found will have the minimised difference

    // outer: 2..infinity
    // inner: 1..outer
    return IntStream.iterate(2, i -> i + 1).boxed()
        .flatMap(
            i -> {
              int pi = pentagon(i);
              return IntStream.range(1, i).mapToObj(j -> Pair.of(pentagon(j), pi));
            })
        .filter(Tuples.predicate((pj, pi) -> isPentagon(pi + pj) && isPentagon(pi - pj)))
        .findFirst().stream()
        .map(Tuples.function((pj, pi) -> pi - pj))
        .findAny()
        .orElseThrow();
  }

  private static int pentagon(int n) {
    return (n * (3 * n - 1)) / 2;
  }

  private static boolean isPentagon(int pn) {
    double inversePentagon = inversePentagon(pn);
    return inversePentagon > 0 && Maths.isInteger(inversePentagon);
  }

  private static double inversePentagon(int pn) {
    // quadratic formula used
    return (1 + Math.sqrt(1 + 24 * pn)) / 6;
  }
}
