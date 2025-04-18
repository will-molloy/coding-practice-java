package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a href=https://leetcode.com/problems/happy-number>https://leetcode.com/problems/happy-number</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key idea: {@link Character#digit(char, int)} method
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P202HappyNumber {

  public boolean isHappy(int n) {
    // cycle detection
    int slow = n;
    int fast = n;
    do {
      slow = next(slow);
      fast = next(next(fast));
      if (slow == 1) {
        return true;
      }
    } while (slow != fast);
    return false;
  }

  private int next(int n) {
    int newN = 0;
    for (char c : String.valueOf(n).toCharArray()) {
      int digit = Character.digit(c, 10);
      newN += digit * digit;
    }
    return newN;
  }
}
