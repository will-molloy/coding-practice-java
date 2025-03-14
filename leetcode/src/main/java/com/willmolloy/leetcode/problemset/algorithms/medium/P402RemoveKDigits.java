package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/remove-k-digits>https://leetcode.com/problems/remove-k-digits/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(n) (not O(n - k) because there is the case all digits are the same)
 *
 * <p>Key idea: No matter what choices you make, the output string will have the same length and
 * maintain the same digit order as the original string. Therefore, want smaller digits at the front
 * of the string (greatest place value); therefore, makes sense to traverse left to right and make
 * the greedy choice of throwing away larger digits.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P402RemoveKDigits {

  public String removeKdigits(String num, int k) {
    Deque<Character> stack = new ArrayDeque<>();

    for (char c : num.toCharArray()) {
      while (k > 0 && !stack.isEmpty() && stack.peekLast() > c) {
        // if next digit is less than previous digits, remove those larger previous digits
        // this is guaranteed to maintain the digit order (i.e. produce a subsequence)
        // this is the greedy choice, want to use the smallest digits at the front of the string
        stack.removeLast();
        k--;
      }
      stack.addLast(c);
    }

    // case where digits were equal e.g. "111"
    while (k > 0) {
      stack.removeLast();
      k--;
    }

    // remove leading zeroes
    while (!stack.isEmpty() && stack.peekFirst() == '0') {
      stack.removeFirst();
    }

    return stack.isEmpty()
        ? "0"
        : stack.stream().map(c -> c.toString()).collect(Collectors.joining());
  }
}
