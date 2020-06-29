package com.wilmol.projecteuler.problems.difficulty5;

import java.util.Optional;
import org.apache.commons.lang3.tuple.Triple;

/**
 * <a href=https://projecteuler.net/problem=9>https://projecteuler.net/problem=9</a>
 *
 * <p>Runtime: O(n ^ 2)
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P9SpecialPythagoreanTriplet {

  public Optional<Triple<Integer, Integer, Integer>> apply(int perimeter) {
    for (int a = 1; a <= perimeter - 2; a++) {
      for (int b = a + 1; b < perimeter - a; b++) {
        int c = perimeter - a - b;
        if (a * a + b * b == c * c) {
          return Optional.of(Triple.of(a, b, c));
        }
      }
    }
    return Optional.empty();
  }
}
