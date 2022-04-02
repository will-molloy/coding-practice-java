package com.willmolloy.projecteuler.problems.difficulty5;

import com.willmolloy.projecteuler.common.Strings;

/**
 * <a href=https://projecteuler.net/problem=43>https://projecteuler.net/problem=43</a>
 *
 * <p>Runtime: none
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P43SubstringDivisibility {

  private P43SubstringDivisibility() {}

  private static final String ZERO_TO_NINE = "0123456789";

  static long pandigitalSumWithDivisibility() {
    return Strings.permutations(ZERO_TO_NINE).stream()
        .parallel()
        .filter(P43SubstringDivisibility::hasDivisibilityProperty)
        .mapToLong(Long::valueOf)
        .sum();
  }

  private static boolean hasDivisibilityProperty(String n) {
    return Integer.parseInt(n.substring(1, 4)) % 2 == 0
        && Integer.parseInt(n.substring(2, 5)) % 3 == 0
        && Integer.parseInt(n.substring(3, 6)) % 5 == 0
        && Integer.parseInt(n.substring(4, 7)) % 7 == 0
        && Integer.parseInt(n.substring(5, 8)) % 11 == 0
        && Integer.parseInt(n.substring(6, 9)) % 13 == 0
        && Integer.parseInt(n.substring(7, 10)) % 17 == 0;
  }
}
