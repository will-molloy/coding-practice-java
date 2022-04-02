package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/valid-parenthesis-string>https://leetcode.com/problems/valid-parenthesis-string</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: Tracking a 'balance' (in this case increment when seeing '(' and decrement when seeing
 * ')'); here we track a balance 'range' (range of current '(').
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P678ValidParenthesisString {

  public boolean checkValidString(String s) {
    // range of how many open brackets there currently are
    // i.e. start represents how many must be closed (i.e. how many '(')
    // end represents how many could be closed (i.e. how many '(' + '*')
    int start = 0;
    int end = 0;
    for (char c : s.toCharArray()) {
      if (c == '(') {
        start++;
        end++;
      } else if (c == ')') {
        if (end == 0) {
          // no '(' to close
          return false;
        }
        end--;
        // want to use ')' greedily (so decrement start but hold at minimum 0)
        // basically end acts as a buffer, if it becomes negative then there weren't enough '(' (or
        // '*' acting as '(') to cover the ')'
        // so we can safely keep 'start' at 0 knowing we closed all '(' that needed to be closed
        start = Math.max(start - 1, 0);
      } else { // c == '*'
        end++;
        // use as ')' greedily (see above for reasoning)
        start = Math.max(start - 1, 0);
      }
    }
    // check we closed all '(' that needed to be closed
    return start == 0;
  }
}
