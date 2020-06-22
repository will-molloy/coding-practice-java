package com.wilmol.projecteuler.problems.difficulty5;

import com.wilmol.projecteuler.common.Maths;
import java.util.Arrays;
import java.util.Locale;

/**
 * Created by will on 2019-04-20 at 11:21 AM.
 *
 * <p><a href=https://projecteuler.net/problem=42>https://projecteuler.net/problem=42</a>
 *
 * <p>Runtime: O(n)
 */
final class P42CodedTriangleNumbers {

  private P42CodedTriangleNumbers() {}

  static long countTriangleWords(String... words) {
    return Arrays.stream(words).parallel().filter(P42CodedTriangleNumbers::isTriangleWord).count();
  }

  private static boolean isTriangleWord(String word) {
    int value = word.toUpperCase(Locale.getDefault()).chars().map(c -> c - 'A' + 1).sum();
    return isTriangleNumber(value);
  }

  private static boolean isTriangleNumber(int value) {
    // naive: iterate all n until value matched
    // return IntStream.iterate(1, n -> n + 1)
    // .map(n -> (n * (n + 1) / 2))
    // .takeWhile(triangleNumber -> triangleNumber <= value)
    // .anyMatch(triangleNumber -> triangleNumber == value);

    // better: inverse the formula (use quadratic formula)
    double inverseTriangleValue = (-1 + Math.sqrt(1 + 8 * value)) / 2;
    // valid if it produced a positive integer
    return inverseTriangleValue > 0 && Maths.isInteger(inverseTriangleValue);
  }
}
