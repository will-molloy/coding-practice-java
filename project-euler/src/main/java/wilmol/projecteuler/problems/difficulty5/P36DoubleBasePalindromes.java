package wilmol.projecteuler.problems.difficulty5;

import static wilmol.projecteuler.common.Strings.isPalindrome;

import java.util.stream.IntStream;

/**
 * Created by will on 2019-04-19 at 3:05 PM.
 *
 * <p><a href=https://projecteuler.net/problem=36>https://projecteuler.net/problem=36</a>
 *
 * <p>Runtime: O(n)
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
