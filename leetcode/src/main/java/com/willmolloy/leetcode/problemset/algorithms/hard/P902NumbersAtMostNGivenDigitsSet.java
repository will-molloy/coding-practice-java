package com.willmolloy.leetcode.problemset.algorithms.hard;

/**
 * <a
 * href=https://leetcode.com/problems/numbers-at-most-n-given-digit-set>https://leetcode.com/problems/numbers-at-most-n-given-digit-set/</a>
 *
 * <p>Runtime: O(log(n)) (length of n in base 10)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Two cases:
 *
 * <ol>
 *   <li>Numbers with fewer digits than n has (x, xx, etc) - all are valid, use {@link Math#pow} to
 *       compute
 *   <li>Numbers with exact digits that n has - consider all prefixes of n and fill in the suffixes
 * </ol>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P902NumbersAtMostNGivenDigitsSet {

  // example:
  // n = 357, digits = [1, 3, 5, 7]

  // x = 4
  // xx = 16
  // 1xx = 16, 3xx = 0, 5xx = 0, 7xx = 0
  // 31x = 4, 33x = 4, 35x = 0, 37x = 0
  // 351 = 1, 353 = 1, 355 = 1, 357 = 1 (at end)

  // total = 4 + 16 + 16 + 2*4 + 4*1 = 48

  public int atMostNGivenDigitSet(String[] digits, int n) {
    // input format is dumb, changing
    char[] digitsChars = String.join("", digits).toCharArray();
    char[] nChars = String.valueOf(n).toCharArray();
    return solve(digitsChars, nChars);
  }

  private int solve(char[] digits, char[] n) {
    int count = 0;

    // numbers with fewer digits than n has (all are valid)
    for (int i = 1; i < n.length; i++) {
      // can form digits.length^i i digit numbers
      count += Math.pow(digits.length, i);
    }

    // numbers with exact digits that n has
    // consider all prefixes of n (n[0, i] for i = [0, n.length)) and fill in the suffixes
    for (int i = 0; i < n.length; i++) {
      boolean in = false;
      for (char digit : digits) {
        if (digit < n[i]) {
          // digit < n[i] means we can fill the remaining places (the suffix) with any digits
          // can form digits.length^(remaining places) numbers
          count += Math.pow(digits.length, n.length - i - 1);
        }
        if (digit == n[i]) {
          // digit == n[i], need to check n[i + 1] too
          in = true;
        }
      }
      if (!in) {
        // n[i] not in digits set, stop here, won't be able to form any numbers <= n[0, i]x...
        // e.g. n = 357, digits [1, 3], i = 1 (n[i] = 5) - can't form any 35x
        return count;
      }
    }
    // all of n covered by digits, so can form n itself, +1 to result
    return count + 1;
  }
}
