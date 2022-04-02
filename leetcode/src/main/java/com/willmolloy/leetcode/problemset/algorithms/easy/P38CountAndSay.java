package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/count-and-say>https://leetcode.com/problems/count-and-say</a>
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P38CountAndSay {

  public String countAndSay(int n) {
    if (n == 1) {
      return "1";
    }
    return countAndSay(countAndSay(n - 1));
  }

  private String countAndSay(String number) {
    StringBuilder builder = new StringBuilder();
    int count = 1;
    char current = number.charAt(0);
    for (int i = 1; i < number.length(); i++) {
      char next = number.charAt(i);
      if (current == next) {
        // count
        count += 1;
      } else {
        // say
        builder.append(count).append(current);
        count = 1;
      }
      current = next;
    }
    // say
    return builder.append(count).append(current).toString();
  }
}
