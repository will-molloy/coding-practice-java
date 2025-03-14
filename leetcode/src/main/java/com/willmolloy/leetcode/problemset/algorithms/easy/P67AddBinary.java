package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a href=https://leetcode.com/problems/add-binary>https://leetcode.com/problems/add-binary</a>
 *
 * <p>Runtime: O(max(a, b))
 *
 * <p>Space: O(max(a, b))
 *
 * <p>Key idea: double pointer, one for each string, convert chars to digits and sum from back with
 * carry.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P2AddTwoNumbers
 * @see P415AddStrings
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P445AddTwoNumbers2
 * @see P1290ConvertBinaryNumberInALinkedListToInteger
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P67AddBinary {

  public String addBinary(String a, String b) {
    StringBuilder result = new StringBuilder();
    add(a, b, a.length() - 1, b.length() - 1, 0, result);
    return result.toString();
  }

  private void add(String a, String b, int aI, int bI, int carry, StringBuilder result) {
    if (aI < 0 && bI < 0 && carry == 0) {
      return;
    }

    int aDigit = aI >= 0 ? Character.digit(a.charAt(aI--), 10) : 0;
    int bDigit = bI >= 0 ? Character.digit(b.charAt(bI--), 10) : 0;
    int sum = aDigit + bDigit + carry;
    int remainder = sum % 2;
    int quotient = sum / 2;

    result.insert(0, remainder);

    add(a, b, aI, bI, quotient, result);
  }
}
