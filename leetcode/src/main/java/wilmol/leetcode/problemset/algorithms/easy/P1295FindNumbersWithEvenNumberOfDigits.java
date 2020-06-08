package wilmol.leetcode.problemset.algorithms.easy;

import java.util.Arrays;

/**
 * Created by wilmol on 2020-06-08.
 *
 * <p><a
 * href=https://leetcode.com/problems/find-numbers-with-even-number-of-digits>https://leetcode.com/problems/find-numbers-with-even-number-of-digits/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Log base 10 + 1 gets number of digits.
 */
class P1295FindNumbersWithEvenNumberOfDigits {

  public int findNumbers(int[] nums) {
    return (int) Arrays.stream(nums).filter(i -> evenNumberOfDigits(i)).count();
  }

  private boolean evenNumberOfDigits(int i) {
    int numDigits = (int) Math.log10(i) + 1;
    return numDigits % 2 == 0;
  }
}
