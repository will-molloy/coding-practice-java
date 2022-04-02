package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;

/**
 * <a
 * href=https://leetcode.com/problems/decode-string>https://leetcode.com/problems/decode-string/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: 2 stacks - 1 for most recent repeat number, 1 to store result before processing bracket
 * contents.
 *
 * @see P227BasicCalculator2
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P394DecodeString {

  public String decodeString(String s) {
    String res = "";
    int num = 0;

    ArrayDeque<Integer> nums = new ArrayDeque<>();
    ArrayDeque<String> strings = new ArrayDeque<>();

    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        num = num * 10 + c - '0';
      } else if (c == '[') {
        nums.push(num);
        num = 0;
        strings.push(res);
        res = "";
      } else if (c == ']') {
        // strings holds contents before the open bracket, res holds contents after, so repeat res
        res = strings.pop() + res.repeat(nums.pop());
      } else {
        res += c;
      }
    }
    return res;
  }
}
