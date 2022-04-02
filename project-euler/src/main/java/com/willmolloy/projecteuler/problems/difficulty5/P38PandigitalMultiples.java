package com.willmolloy.projecteuler.problems.difficulty5;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href=https://projecteuler.net/problem=38>https://projecteuler.net/problem=38</a>
 *
 * <p>Runtime: none
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P38PandigitalMultiples {

  private P38PandigitalMultiples() {}

  private static final String NINE_TO_ONE = "987654321";

  static int max1To9PandigitalNumber() {
    // n = 1, would just be 987654321 (trivial)
    // n > 9, would only generate values with more than 9 digits
    return IntStream.rangeClosed(2, 9)
        .parallel()
        .map(P38PandigitalMultiples::max1To9PandigitalNumberFor)
        .max()
        .orElseThrow();
  }

  static int max1To9PandigitalNumberFor(int n) {
    Preconditions.checkArgument(n > 1 && n <= 9);

    // iterate descending: since largest number determined by starting digits
    int startValue = Integer.parseInt(NINE_TO_ONE.substring(0, 9 / n));

    return IntStream.iterate(startValue, i -> i - 1)
        .filter(
            i -> {
              // base number needs unique digits
              String s = String.valueOf(i);
              return !s.contains("0") && s.chars().distinct().count() == s.length();
            })
        // build pandigital number
        .mapToObj(candidate -> pandigitalNumber(n, candidate))
        // stop once we start generating numbers with less than 9 digits (will never match 1 to 9)
        .takeWhile(pandigitalNumber -> pandigitalNumber.length() >= 9)
        // find first 1 to 9 pandigital (will be maximum since started from largest base value)
        .filter(
            pandigitalNumber ->
                pandigitalNumber.length() == 9
                    && pandigitalNumber
                        .chars()
                        .map(Character::getNumericValue)
                        .mapToObj(String::valueOf)
                        // sort for easy comparison with 1..9
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.joining())
                        .equals(NINE_TO_ONE))
        .mapToInt(Integer::valueOf)
        .findFirst()
        .orElse(-1);
  }

  private static String pandigitalNumber(int n, int base) {
    int[] multiples = IntStream.rangeClosed(1, n).map(multiplier -> multiplier * base).toArray();
    return Ints.join("", multiples);
  }
}
