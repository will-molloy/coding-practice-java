package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a href=https://leetcode.com/problems/add-strings>https://leetcode.com/problems/add-strings/</a>
 *
 * <p>Runtime: O(max(num1, num2))
 *
 * <p>Extra space: O(max(num1, num2)) (recursion stack size)
 *
 * <p>Key idea: Simulate process of adding decimal numbers. I.e. line up their ends and sum
 * individual digits with a carry.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P2AddTwoNumbers
 * @see P67AddBinary
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P445AddTwoNumbers2
 * @see P1290ConvertBinaryNumberInALinkedListToInteger
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P415AddStrings {

  public String addStrings(String num1, String num2) {
    StringBuilder ans = new StringBuilder();
    add(num1, num1.length() - 1, num2, num2.length() - 1, 0, ans);
    return ans.toString();
  }

  private void add(String num1, int num1I, String num2, int num2I, int carry, StringBuilder ans) {
    if (num1I < 0 && num2I < 0 && carry == 0) {
      return;
    }

    int num1Digit = num1I >= 0 ? Character.digit(num1.charAt(num1I--), 10) : 0;
    int num2Digit = num2I >= 0 ? Character.digit(num2.charAt(num2I--), 10) : 0;
    int sum = num1Digit + num2Digit + carry;
    int remainder = sum % 10;
    int quotient = sum / 10;

    ans.insert(0, remainder);

    add(num1, num1I, num2, num2I, quotient, ans);
  }
}
