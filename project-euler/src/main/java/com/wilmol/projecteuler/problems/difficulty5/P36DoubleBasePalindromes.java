package com.wilmol.projecteuler.problems.difficulty5;

import static com.wilmol.projecteuler.common.Strings.isPalindrome;

import java.util.stream.IntStream;

/**
 * <a href=https://projecteuler.net/problem=36>https://projecteuler.net/problem=36</a>
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
final class P36DoubleBasePalindromes {

  private P36DoubleBasePalindromes() {}

  static int doubleBasePalindromeSum(int limit) {
    return IntStream.range(1, limit)
        .parallel()
        .filter(P36DoubleBasePalindromes::isDoubleBasePalindrome)
        .sum();
  }

  private static boolean isDoubleBasePalindrome(int n) {
    return isPalindrome(String.valueOf(n)) && isPalindrome(Integer.toBinaryString(n));
  }
}
