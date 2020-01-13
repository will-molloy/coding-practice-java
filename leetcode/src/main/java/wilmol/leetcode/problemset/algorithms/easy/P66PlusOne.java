package wilmol.leetcode.problemset.algorithms.easy;

import java.util.Arrays;

/**
 * Created by wilmol on 2020-01-13.
 *
 * <p><a href=https://leetcode.com/problems/plus-one>https://leetcode.com/problems/plus-one</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n) (sometimes copy array)
 *
 * <p>Key: recursion
 */
class P66PlusOne {

  public int[] plusOne(int[] digits) {
    return plusOne(digits, digits.length - 1);
  }

  private int[] plusOne(int[] digits, int i) {
    if (i == -1) {
      // must be array of 9s
      int[] copy = new int[digits.length + 1];
      copy[0] = 1;
      return copy;
    }

    if (digits[i] < 9) {
      digits[i] = digits[i] + 1;
      return digits;
    } else if (digits[i] == 9) {
      digits[i] = 0;
      return plusOne(digits, i - 1);
    } else {
      throw new IllegalArgumentException(
          String.format("Element > 9 at index %s in array %s", i, Arrays.toString(digits)));
    }
  }
}
