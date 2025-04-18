package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a href=https://leetcode.com/problems/plus-one>https://leetcode.com/problems/plus-one</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n) (sometimes copy array)
 *
 * <p>Key idea: recursion
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P66PlusOne {

  public int[] plusOne(int[] digits) {
    int n = digits.length;

    int carry = 0;
    int add = 1;
    for (int i = n - 1; i >= 0; i--) {
      int sum = digits[i] + add + carry;
      add = 0;
      carry = sum % 9;

      if (sum > 9) {
        if (i == 0) {
          int[] newArray = new int[n + 1];
          newArray[0] = 1;
          return newArray;
        } else {
          digits[i] = 0;
        }
      } else {
        digits[i] = sum;
        break;
      }
    }
    return digits;
  }
}
